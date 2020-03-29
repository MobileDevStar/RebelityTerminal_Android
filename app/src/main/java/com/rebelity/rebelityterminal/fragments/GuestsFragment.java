package com.rebelity.rebelityterminal.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rebelity.rebelityterminal.DetailsActivity;
import com.rebelity.rebelityterminal.R;
import com.rebelity.rebelityterminal.adapters.GuestsExAdapter;
import com.rebelity.rebelityterminal.models.GuestsModel;

import java.util.ArrayList;

public class GuestsFragment extends Fragment {

    private ArrayList<GuestsModel>      guestModelArrayList;
    private ExpandableListView          guestsExListView;
    private DetailsActivity             activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        activity = (DetailsActivity) getActivity();

        return inflater.inflate(R.layout.guests_container, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();

        guestsExListView = view.findViewById(R.id.guests_list_view);
        guestModelArrayList = populateGuestList();

        if (guestModelArrayList.size()> 0) {
            GuestsExAdapter salesAdapter = new GuestsExAdapter(activity, guestModelArrayList);
            guestsExListView.setAdapter(salesAdapter);
        }

    }

    private ArrayList<GuestsModel> populateGuestList() {
        ArrayList<GuestsModel> list = new ArrayList<>();
        String[] tickets = {"Training session1", "couples Ticket", "couples Ticket"};
        for(int i = 0; i < 10; i++){
            GuestsModel guestsModel = new GuestsModel(i,"Kashia-Bsmnt",  tickets ,true, true, true);
            list.add(guestsModel);
        }

        return list;
    }
}