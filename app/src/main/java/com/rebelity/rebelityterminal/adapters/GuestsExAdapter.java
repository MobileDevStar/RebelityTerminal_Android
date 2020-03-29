package com.rebelity.rebelityterminal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.rebelity.rebelityterminal.R;
import com.rebelity.rebelityterminal.models.GuestsModel;

import java.util.ArrayList;

public class GuestsExAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<GuestsModel> guestsModelArrayList;

    public GuestsExAdapter(Context context, ArrayList<GuestsModel> guestsModelArrayList) {
        this.context = context;
        this.guestsModelArrayList = guestsModelArrayList;
    }

    @Override
    public int getGroupCount() {
        return this.guestsModelArrayList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        String[] tickets = this.guestsModelArrayList.get(groupPosition).getTickets();

        return tickets.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.guestsModelArrayList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        String[] tickets = this.guestsModelArrayList.get(groupPosition).getTickets();

        return tickets[childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder holder;

        if (convertView == null) {
            holder = new GroupViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.guests_list_group, null, true);

            holder.tvGuest = (TextView) convertView.findViewById(R.id.guest_list_name);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (GroupViewHolder)convertView.getTag();
        }

        GuestsModel guest = this.guestsModelArrayList.get(groupPosition);

        holder.tvGuest.setText(guest.getName());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder holder;

        if (convertView == null) {
            holder = new ChildViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.guests_list_row, null, true);

            holder.tvTicket = (TextView) convertView.findViewById(R.id.guest_list_ticket);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ChildViewHolder)convertView.getTag();
        }

        String[] tickets = this.guestsModelArrayList.get(groupPosition).getTickets();
        final String ticket = tickets[childPosition];

        holder.tvTicket.setText(ticket + ": ");

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    private class ChildViewHolder {
        TextView tvTicket;
    }

    private class GroupViewHolder {
        TextView tvGuest;
    }
}
