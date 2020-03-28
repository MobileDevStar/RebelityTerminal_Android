package com.rebelity.rebelityterminal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.rebelity.rebelityterminal.adapters.TicketAdapter;
import com.rebelity.rebelityterminal.models.TicketModel;

import java.util.ArrayList;

import static com.rebelity.rebelityterminal.MainActivity.reLayoutListView;

public class DetailsActivity extends AppCompatActivity {

    private ArrayList<TicketModel>   ticketModelArrayList;
    private ListView ticketListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ticketListView = findViewById(R.id.ticket_list_view);

        ticketModelArrayList = populateTicketList();

        if (ticketModelArrayList.size() > 0) {
            TicketAdapter ticketAdapter = new TicketAdapter(this, ticketModelArrayList);
            ticketListView.setAdapter(ticketAdapter);

            reLayoutListView(ticketListView, 5);
        }
    }

    private ArrayList<TicketModel> populateTicketList() {
        ArrayList<TicketModel> list = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            TicketModel ticketModel = new TicketModel(i, "Singles Ticket", 2, (float)90.0);
            list.add(ticketModel);
        }

        return list;
    }
}
