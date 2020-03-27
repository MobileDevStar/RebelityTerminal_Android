package com.rebelity.rebelityterminal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rebelity.rebelityterminal.R;
import com.rebelity.rebelityterminal.models.EventModel;

import java.util.ArrayList;

public class EventAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<EventModel> eventModelArrayList;

    public EventAdapter(Context context, ArrayList<EventModel> eventModelArrayList) {

        this.context = context;
        this.eventModelArrayList= eventModelArrayList;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return eventModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return eventModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.event_list_row, null, true);

            holder.tvEvent = (TextView) convertView.findViewById(R.id.event_list_event);
            holder.tvInstance = (TextView) convertView.findViewById(R.id.event_list_instance);
            holder.tvContact = (TextView) convertView.findViewById(R.id.event_list_contact);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvEvent .setText(eventModelArrayList.get(position).getEvent());
        holder.tvInstance.setText(eventModelArrayList.get(position).getInstance());
        holder.tvContact.setText(eventModelArrayList.get(position).getContact());

        return convertView;
    }

    private class ViewHolder {
        TextView tvEvent, tvInstance, tvContact;
    }
}
