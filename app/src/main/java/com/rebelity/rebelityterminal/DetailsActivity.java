package com.rebelity.rebelityterminal;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;
import com.rebelity.rebelityterminal.fragments.GuestsFragment;
import com.rebelity.rebelityterminal.fragments.SalesFragment;
import com.rebelity.rebelityterminal.fragments.TicketsFragment;
import com.rebelity.rebelityterminal.adapters.RebelityTapAdapter;
import com.rebelity.rebelityterminal.components.WrappingViewPager;

public class DetailsActivity extends AppCompatActivity {

    private RebelityTapAdapter adapter;
    private TabLayout           tabLayout;
    private WrappingViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView titleView = (TextView)findViewById(R.id.event_title_name);
        titleView.setSelected(true);

        viewPager = (WrappingViewPager) findViewById(R.id.ticket_details_pages);
        tabLayout = (TabLayout) findViewById(R.id.ticket_details_tablayout);

        adapter = new RebelityTapAdapter(this, getSupportFragmentManager());

        adapter.addFragment(new TicketsFragment(), getString(R.string.tickets_tab_label));
        adapter.addFragment(new GuestsFragment(), getString(R.string.guests_tab_label));
        adapter.addFragment(new SalesFragment(), getString(R.string.sales_tab_label));

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }

    public void onClickBack(View v) {
        finish();
    }
}
