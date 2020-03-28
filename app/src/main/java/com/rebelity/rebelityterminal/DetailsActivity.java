package com.rebelity.rebelityterminal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;

import com.rebelity.rebelityterminal.adapters.TicketListAdapter;
import com.rebelity.rebelityterminal.adapters.TicketRecyclerAdapter;
import com.rebelity.rebelityterminal.models.TicketModel;

import java.util.ArrayList;

import static com.rebelity.rebelityterminal.MainActivity.reLayoutListView;

public class DetailsActivity extends AppCompatActivity {

    private ArrayList<TicketModel>   ticketModelArrayList;
    private ListView                 ticketListView;

    private ArrayList<TicketModel>      ticketCardArrayList;
    private RecyclerView.LayoutManager  ticketRecyclerLayoutManager;
    private RecyclerView                ticketRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ticketListView = findViewById(R.id.ticket_list_view);
        ticketModelArrayList = populateTicketList();

        if (ticketModelArrayList.size() > 0) {
            TicketListAdapter ticketAdapter = new TicketListAdapter(this, ticketModelArrayList);
            ticketListView.setAdapter(ticketAdapter);

            reLayoutListView(ticketListView, 5);
        }

        ticketRecyclerView = (RecyclerView)findViewById(R.id.ticket_discount_recycler);
        ticketRecyclerView.setHasFixedSize(true);

        ticketRecyclerLayoutManager = new GridLayoutManager(this, 2);
        ticketRecyclerView.setLayoutManager(ticketRecyclerLayoutManager);
        ticketRecyclerView.setItemAnimator(new DefaultItemAnimator());

        ticketCardArrayList = populateTicketList();
        TicketRecyclerAdapter ticketCardAdapter = new TicketRecyclerAdapter(ticketCardArrayList);
        ticketRecyclerView.setAdapter(ticketCardAdapter);

        //ticketRecyclerView.get
//
//        int itemHeight = ticketCardAdapter.getItemHeight();
//        int itemCnt = ticketCardAdapter.getItemCount();
//
//        ViewGroup.LayoutParams params = ticketRecyclerView.getLayoutParams();
//        params.height = itemHeight* itemCnt;
//        ticketRecyclerView.setLayoutParams(params);
//        ticketRecyclerView.requestLayout();

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
