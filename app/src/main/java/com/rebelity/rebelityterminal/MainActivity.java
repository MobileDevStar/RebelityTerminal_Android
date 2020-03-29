package com.rebelity.rebelityterminal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;
import com.rebelity.rebelityterminal.adapters.EventAdapter;
import com.rebelity.rebelityterminal.adapters.RebelityTapAdapter;
import com.rebelity.rebelityterminal.adapters.TerminalAdapter;
import com.rebelity.rebelityterminal.components.WrappingViewPager;
import com.rebelity.rebelityterminal.fragments.EventsFragment;
import com.rebelity.rebelityterminal.fragments.TerminalsFragment;
import com.rebelity.rebelityterminal.models.EventModel;
import com.rebelity.rebelityterminal.models.TerminalModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RebelityTapAdapter adapter;
    private TabLayout tabLayout;
    private WrappingViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        viewPager = (WrappingViewPager) findViewById(R.id.main_pages);
        tabLayout = (TabLayout) findViewById(R.id.main_tab_layout);

        adapter = new RebelityTapAdapter(this, getSupportFragmentManager());
        adapter.addFragment(new EventsFragment(), getString(R.string.events_tab_label));
        adapter.addFragment(new TerminalsFragment(), getString(R.string.terminal_tab_label));

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        View logout = findViewById(R.id.logout_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
}
