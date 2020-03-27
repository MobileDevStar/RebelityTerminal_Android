package com.rebelity.rebelityterminal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.rebelity.rebelityterminal.R;
import com.rebelity.rebelityterminal.models.EventModel;
import com.rebelity.rebelityterminal.models.TerminalModel;

import java.util.ArrayList;

public class TerminalAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<TerminalModel> terminalModelArrayList;

    public TerminalAdapter(Context context, ArrayList<TerminalModel> terminalModelArrayList) {

        this.context = context;
        this.terminalModelArrayList = terminalModelArrayList;
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
        return terminalModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return terminalModelArrayList.get(position);
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

            convertView = inflater.inflate(R.layout.terminal_list_row, null, true);

            holder.tvTerminal = (TextView) convertView.findViewById(R.id.terminal_list_terminal);
            holder.tvStatus = (TextView) convertView.findViewById(R.id.terminal_list_status);
            holder.butConnect = (Button) convertView.findViewById(R.id.terminal_list_connect);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvTerminal.setText(terminalModelArrayList.get(position).getName());
        holder.tvStatus.setText(terminalModelArrayList.get(position).getStatus());

        return convertView;
    }

    private class ViewHolder {
        TextView tvTerminal, tvStatus, butConnect;
    }
}
