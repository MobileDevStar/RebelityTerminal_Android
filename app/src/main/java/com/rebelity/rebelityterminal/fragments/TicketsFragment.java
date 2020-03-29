package com.rebelity.rebelityterminal.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rebelity.rebelityterminal.DetailsActivity;
import com.rebelity.rebelityterminal.R;
import com.rebelity.rebelityterminal.adapters.TicketListAdapter;
import com.rebelity.rebelityterminal.adapters.TicketRecyclerAdapter;
import com.rebelity.rebelityterminal.models.TicketModel;

import java.util.ArrayList;

import static com.rebelity.rebelityterminal.MainActivity.reLayoutListView;

public class TicketsFragment extends Fragment {

    private ArrayList<TicketModel> ticketModelArrayList;
    private ListView ticketListView;

    private ArrayList<TicketModel>      ticketCardArrayList;
    private RecyclerView.LayoutManager  ticketRecyclerLayoutManager;
    private RecyclerView                ticketRecyclerView;

    private DetailsActivity             activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        activity = (DetailsActivity)getActivity();
        View view = inflater.inflate(R.layout.tickets_container, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();

        ticketListView = view.findViewById(R.id.ticket_list_view);
        ticketModelArrayList = populateTicketList();

        if (ticketModelArrayList.size() > 0) {
            TicketListAdapter ticketAdapter = new TicketListAdapter(activity, ticketModelArrayList);
            ticketListView.setAdapter(ticketAdapter);

            reLayoutListView(ticketListView, 5);
        }

        ticketRecyclerView = (RecyclerView)view.findViewById(R.id.ticket_discount_recycler);
        ticketRecyclerView.setHasFixedSize(true);

        ticketRecyclerLayoutManager = new GridLayoutManager(activity, 2);
        ticketRecyclerView.setLayoutManager(ticketRecyclerLayoutManager);
        ticketRecyclerView.setItemAnimator(new DefaultItemAnimator());

        ticketCardArrayList = populateTicketList();
        TicketRecyclerAdapter ticketCardAdapter = new TicketRecyclerAdapter(ticketCardArrayList);
        ticketRecyclerView.setAdapter(ticketCardAdapter);
    }

    private ArrayList<TicketModel> populateTicketList() {
        ArrayList<TicketModel> list = new ArrayList<>();

        for(int i = 0; i < 7; i++){
            TicketModel ticketModel = new TicketModel(i, "Singles Ticket", 2, (float)90.0);
            list.add(ticketModel);
        }

        return list;
    }
}