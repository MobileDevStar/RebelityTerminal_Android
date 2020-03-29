package com.rebelity.rebelityterminal.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rebelity.rebelityterminal.MainActivity;
import com.rebelity.rebelityterminal.R;
import com.rebelity.rebelityterminal.adapters.TerminalAdapter;
import com.rebelity.rebelityterminal.models.TerminalModel;

import java.util.ArrayList;

public class TerminalsFragment extends Fragment implements View.OnClickListener {

    private ArrayList<TerminalModel>    terminalModelArrayList;
    private ListView                    terminalListView;
    private MainActivity                activity;
    private View                        vTerminalRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        activity = (MainActivity)getActivity();

        return inflater.inflate(R.layout.terminals_container, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();

        terminalListView = view.findViewById(R.id.terminal_list_view);
        terminalModelArrayList = populateTerminalList();

        if (terminalModelArrayList.size()> 0) {
            TerminalAdapter terminalAdapter = new TerminalAdapter(activity, terminalModelArrayList);
            terminalListView.setAdapter(terminalAdapter );
        }

        view.findViewById(R.id.register_new_reader).setOnClickListener(this);
        view.findViewById(R.id.terminal_register_cancel).setOnClickListener(this);
        view.findViewById(R.id.terminal_register).setOnClickListener(this);

        vTerminalRegister = view.findViewById(R.id.register_reader_container);
    }

    private ArrayList<TerminalModel> populateTerminalList() {
        ArrayList<TerminalModel> list = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            TerminalModel terminalModel = new TerminalModel(i, "Kashia-Bsmnt", "offline");
            list.add(terminalModel);
        }

        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_new_reader:
                showRegisterContainer(true);
                break;
            case R.id.terminal_register:
                showRegisterContainer(false);
                break;
            case R.id.terminal_register_cancel:
                showRegisterContainer(false);
                break;
        }
    }

    private void showRegisterContainer(boolean blShow) {
        if (blShow == true) {
            vTerminalRegister.setVisibility(View.VISIBLE);
        } else {
            vTerminalRegister.setVisibility(View.GONE);
        }
    }
}