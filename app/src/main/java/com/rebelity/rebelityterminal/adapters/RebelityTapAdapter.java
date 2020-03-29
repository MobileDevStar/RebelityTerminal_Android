package com.rebelity.rebelityterminal.adapters;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.rebelity.rebelityterminal.components.WrappingViewPager;

import java.util.ArrayList;
import java.util.List;

public class RebelityTapAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    private int mCurrentPosition = -1;
    private Context             mContext;

    public RebelityTapAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

   // @Override
 //   public void setPrimaryItem(ViewGroup container, int position, Object object) {
 //       super.setPrimaryItem(container, position, object);
        /*if (position != mCurrentPosition) {
            Fragment fragment = (Fragment) object;
            WrappingViewPager pager = (WrappingViewPager) container;
            if (fragment != null && fragment.getView() != null) {
                mCurrentPosition = position;
                pager.measureCurrentView(fragment.getView());
            }
        }*/
//    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }
    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
    @Override
    public int getCount() {
        return mFragmentList.size();
    }


}