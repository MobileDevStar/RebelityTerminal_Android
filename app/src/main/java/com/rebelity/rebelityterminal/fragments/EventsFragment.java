package com.rebelity.rebelityterminal.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rebelity.rebelityterminal.MainActivity;
import com.rebelity.rebelityterminal.R;
import com.rebelity.rebelityterminal.adapters.EventAdapter;
import com.rebelity.rebelityterminal.models.EventModel;

import java.util.ArrayList;

public class EventsFragment extends Fragment {

    private ArrayList<EventModel>   eventModelArrayList;
    private ListView                eventListView;
    private MainActivity            activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        activity = (MainActivity)getActivity();

        return inflater.inflate(R.layout.events_container, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();

        eventListView = view.findViewById(R.id.event_list_view);
        eventModelArrayList = populateEventList();

        if (eventModelArrayList.size() > 0) {
            EventAdapter eventAdapter = new EventAdapter(activity, eventModelArrayList);
            eventListView.setAdapter(eventAdapter);

            //reLayoutListView(eventListView, 5);
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

}