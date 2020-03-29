package com.rebelity.rebelityterminal.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rebelity.rebelityterminal.DetailsActivity;
import com.rebelity.rebelityterminal.R;
import com.rebelity.rebelityterminal.adapters.SalesAdapter;
import com.rebelity.rebelityterminal.models.SalesModel;

import java.util.ArrayList;

public class SalesFragment extends Fragment {

    private ArrayList<SalesModel>       salesModelArrayList;
    private ListView                    salesListView;
    private DetailsActivity             activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        activity = (DetailsActivity) getActivity();

        return inflater.inflate(R.layout.sales_container, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();

        salesListView = view.findViewById(R.id.sales_list_view);
        salesModelArrayList = populateSalesList();

        if (salesModelArrayList.size()> 0) {
            SalesAdapter salesAdapter = new SalesAdapter(activity, salesModelArrayList);
            salesListView.setAdapter(salesAdapter);
        }

    }

    private ArrayList<SalesModel> populateSalesList() {
        ArrayList<SalesModel> list = new ArrayList<>();
        String[] tickets = {"Training session1", "couples Ticket"};
        for(int i = 0; i < 10; i++){
            SalesModel salesModel = new SalesModel(i, tickets , "Kashia-Bsmnt", (float)360.0, "cash", "3/26/2020 1:08 pm");
            list.add(salesModel);
        }

        return list;
    }
}