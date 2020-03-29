package com.rebelity.rebelityterminal.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rebelity.rebelityterminal.DetailsActivity;
import com.rebelity.rebelityterminal.R;
import com.rebelity.rebelityterminal.models.EventModel;
import com.rebelity.rebelityterminal.models.SalesModel;

import java.util.ArrayList;

public class SalesAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SalesModel> salesModelArrayList;

    public SalesAdapter(Context context, ArrayList<SalesModel> salesModelArrayList) {

        this.context = context;
        this.salesModelArrayList = salesModelArrayList;
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
        return salesModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return salesModelArrayList.get(position);
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

            convertView = inflater.inflate(R.layout.sales_list_row, null, true);

            holder.tvTickets = (TextView) convertView.findViewById(R.id.sales_list_tickets);
            holder.tvCustomer= (TextView) convertView.findViewById(R.id.sales_list_customer);
            holder.tvPrice= (TextView) convertView.findViewById(R.id.sales_list_price);
            holder.tvType= (TextView) convertView.findViewById(R.id.sales_list_type);
            holder.tvTime= (TextView) convertView.findViewById(R.id.sales_list_time);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        SalesModel sale = salesModelArrayList.get(position);
        String[] tickets = sale.getTickets();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < tickets.length; i++) {
            sb.append(tickets[i]);
            if (i < tickets.length - 1) {
                sb.append("\n");
            }
        }
        String strTickets = sb.toString();
        holder.tvTickets.setText(strTickets);

        holder.tvCustomer.setText(salesModelArrayList.get(position).getCustomer());

        holder.tvPrice.setText("$" + Float.toString(sale.getTotalPrice()));

        holder.tvType.setText(sale.getPayType());
        holder.tvTime.setText(sale.getTime());

        return convertView;
    }

    private class ViewHolder {
        TextView tvTickets, tvCustomer, tvPrice, tvType, tvTime;
    }
}
