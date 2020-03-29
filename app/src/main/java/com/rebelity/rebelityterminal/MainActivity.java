package com.rebelity.rebelityterminal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.rebelity.rebelityterminal.adapters.EventAdapter;
import com.rebelity.rebelityterminal.adapters.TerminalAdapter;
import com.rebelity.rebelityterminal.models.EventModel;
import com.rebelity.rebelityterminal.models.TerminalModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<EventModel>   eventModelArrayList;
    private ListView                eventListView;

    private ArrayList<TerminalModel>   terminalModelArrayList;
    private ListView                terminalListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View logout = findViewById(R.id.logout_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        eventListView = findViewById(R.id.event_list_view);
        terminalListView = findViewById(R.id.terminal_list_view);

        eventModelArrayList = populateEventList();
        terminalModelArrayList = populateTerminalList();

        if (eventModelArrayList.size() > 0) {
            EventAdapter eventAdapter = new EventAdapter(this, eventModelArrayList);
            eventListView.setAdapter(eventAdapter);

            reLayoutListView(eventListView, 5);
        }

        if (terminalModelArrayList.size()> 0) {
            TerminalAdapter terminalAdapter = new TerminalAdapter(this, terminalModelArrayList);
            terminalListView.setAdapter(terminalAdapter );

            reLayoutListView(terminalListView, 5);
        }
    }

    private ArrayList<EventModel> populateEventList() {
        ArrayList<EventModel> list = new ArrayList<>();

        for(int i = 0; i < 7; i++){
            EventModel eventModel = new EventModel(i, "Marietta High School", "12/29/2019 10:30PM-4/25/2020 10:30PM", "Prom-Domo");
            list.add(eventModel);
        }

        return list;
    }

    private ArrayList<TerminalModel> populateTerminalList() {
        ArrayList<TerminalModel> list = new ArrayList<>();

        for(int i = 0; i < 7; i++){
            TerminalModel terminalModel = new TerminalModel(i, "Kashia-Bsmnt", "offline");
            list.add(terminalModel);
        }

        return list;
    }

    public static void reLayoutListView(ListView listView, int limitCnt) {

        ListAdapter mAdapter = listView.getAdapter();

        int totalHeight = 0;
        int adapterCnt = mAdapter.getCount();
        int showCnt = adapterCnt;//adapterCnt < limitCnt ? adapterCnt : limitCnt;

        for (int i = 0; i < showCnt; i++) {
            View mView = mAdapter.getView(i, null, listView);
            mView.measure(
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

            totalHeight += mView.getMeasuredHeight();
            Log.w("HEIGHT" + i, String.valueOf(totalHeight));
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (showCnt - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
//
//    public static void reLayoutRecyclerView(RecyclerView recyclerView, int cols) {
//
//        RecyclerView.Adapter mAdapter = recyclerView.getAdapter();
//
//        int totalHeight = 0;
//        int adapterCnt = mAdapter.getItemCount();
//        int showCnt = adapterCnt;//adapterCnt < limitCnt ? adapterCnt : limitCnt;
//
//        for (int i = 0; i < showCnt; i++) {
//            mAdapter.
//            View mView = mAdapter.getView(i, null, listView);
//            mView.measure(
//                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
//                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
//
//            totalHeight += mView.getMeasuredHeight();
//            Log.w("HEIGHT" + i, String.valueOf(totalHeight));
//        }
//
//        ViewGroup.LayoutParams params = listView.getLayoutParams();
//        params.height = totalHeight
//                + (listView.getDividerHeight() * (showCnt - 1));
//        listView.setLayoutParams(params);
//        listView.requestLayout();
//    }
}
