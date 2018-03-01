package com.am.scheduling.presentation.core.tab;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.am.scheduling.presentation.core.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class TabAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> mFragments;
    private List<String> mTitles;

    public TabAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
        mTitles = new ArrayList<>();
    }

    public void addFragment(BaseFragment fragment, String title) {
        mFragments.add(fragment);
        mTitles.add(title);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
