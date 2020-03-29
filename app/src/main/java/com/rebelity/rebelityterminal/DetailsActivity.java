package com.rebelity.rebelityterminal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;
import com.rebelity.rebelityterminal.TicketFragments.GuestsFragment;
import com.rebelity.rebelityterminal.TicketFragments.SalesFragment;
import com.rebelity.rebelityterminal.TicketFragments.TicketsFragment;
import com.rebelity.rebelityterminal.adapters.TicketTapAdapter;
import com.rebelity.rebelityterminal.components.WrappingViewPager;

public class DetailsActivity extends AppCompatActivity {

    private TicketTapAdapter    adapter;
    private TabLayout           tabLayout;
    private WrappingViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        viewPager = (WrappingViewPager) findViewById(R.id.ticket_details_pages);
        tabLayout = (TabLayout) findViewById(R.id.ticket_details_tablayout);

        adapter = new TicketTapAdapter(this, getSupportFragmentManager());
        adapter.addFragment(new SalesFragment(), getString(R.string.sales_label));
        adapter.addFragment(new GuestsFragment(), getString(R.string.guests_label));
        adapter.addFragment(new TicketsFragment(), getString(R.string.tickets_label));

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }

}
