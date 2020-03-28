package com.rebelity.rebelityterminal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rebelity.rebelityterminal.R;
import com.rebelity.rebelityterminal.models.EventModel;
import com.rebelity.rebelityterminal.models.TicketModel;

import java.util.ArrayList;

import info.androidhive.fontawesome.FontTextView;

public class TicketAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<TicketModel> ticketModelArrayList;

    public TicketAdapter(Context context, ArrayList<TicketModel> ticketModelArrayList) {

        this.context = context;
        this.ticketModelArrayList = ticketModelArrayList;
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
        return ticketModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return ticketModelArrayList.get(position);
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

            convertView = inflater.inflate(R.layout.ticket_list_row, null, true);

            holder.tvName = (TextView) convertView.findViewById(R.id.ticket_row_name);
            holder.tvQuantity = (TextView) convertView.findViewById(R.id.ticket_row_quantity);
            holder.tvPrice= (TextView) convertView.findViewById(R.id.ticket_row_price);
            holder.tvTotal= (TextView) convertView.findViewById(R.id.ticket_row_total);
            holder.ftMinus= (FontTextView) convertView.findViewById(R.id.ticket_row_minus);
            holder.ftRemove= (FontTextView) convertView.findViewById(R.id.ticket_row_remove);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvName.setText(ticketModelArrayList.get(position).getName());

        int quantity = ticketModelArrayList.get(position).getQuantity();
        holder.tvQuantity.setText("×" + Integer.toString(quantity));

        float price = ticketModelArrayList.get(position).getPrice();
        holder.tvPrice.setText("$" + Float.toString(price));

        holder.tvTotal.setText("$" + Float.toString(price * quantity));

        return convertView;
    }

    private class ViewHolder {
        TextView tvName, tvQuantity, tvPrice, tvTotal;
        FontTextView ftMinus, ftRemove;
    }
}
