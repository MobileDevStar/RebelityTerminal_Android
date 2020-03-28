package com.rebelity.rebelityterminal.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.rebelity.rebelityterminal.R;
import com.rebelity.rebelityterminal.models.TicketModel;

import java.util.ArrayList;

public class TicketCardAdapter extends RecyclerView.Adapter<TicketCardAdapter.MyViewHolder> {

    private ArrayList<TicketModel> list;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvPrice;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.tvName= (TextView) itemView.findViewById(R.id.ticket_card_name);
            this.tvPrice = (TextView) itemView.findViewById(R.id.ticket_card_price);
        }
    }

    public TicketCardAdapter(ArrayList<TicketModel> data) {
        this.list = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ticket_recycler_card, parent, false);

        //view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView tvName = holder.tvName;
        TextView tvPrice = holder.tvPrice;

        tvName.setText(list.get(listPosition).getName());
        tvPrice.setText("$" + Float.toString(list.get(listPosition).getPrice()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

