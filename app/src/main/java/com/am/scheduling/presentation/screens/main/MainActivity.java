package com.am.scheduling.presentation.screens.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;

import com.am.scheduling.R;
import com.am.scheduling.presentation.core.base.BaseFragment;
import com.am.scheduling.presentation.core.base.toolbar.DefaultToolbarAdapter;
import com.am.scheduling.presentation.core.base.toolbar.TitleToolbarView;
import com.am.scheduling.presentation.core.base.toolbar.ToolbarAdapter;
import com.am.scheduling.presentation.core.content.StackActivity;
import com.am.scheduling.presentation.screens.main.managment.ManagementFragment;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class MainActivity extends StackActivity<MainContract.Presenter>
        implements MainContract.View {

    public static Intent newLaunchIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Inject
    MainContract.Presenter mPresenter;

    @BindView(R.id.toolbar_am)
    Toolbar mToolbarAm;
    @BindView(R.id.ctl_toolbar_container_am)
    CollapsingToolbarLayout mCtlToolbarContainerAm;
    @BindView(R.id.tabs_navigation_am)
    TabLayout mTabsNavigationAm;

    private TabLayout.OnTabSelectedListener mTabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            selectTab(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
            selectTab(tab.getPosition());
        }
    };

    @Override
    public MainContract.Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    public int getFragmentContainer() {
        return R.id.frame_container_am;
    }

    @Override
    protected ToolbarAdapter getToolbarAdapter() {
        return new DefaultToolbarAdapter(mToolbarAm, mCtlToolbarContainerAm);
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        getToolbarManager().setContentView(new TitleToolbarView());
        mTabsNavigationAm.addOnTabSelectedListener(mTabSelectedListener);
        getPresenter().onViewReady(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        mTabsNavigationAm.removeOnTabSelectedListener(mTabSelectedListener);
        super.onDestroy();
    }

    private void selectTab(@IntRange(from = 0)int tabId) {
        getNavigator().clearBackStack();
        getNavigator().showFragment(getRootFragmentByTab(tabId));
    }

    private BaseFragment getRootFragmentByTab(@IntRange(from = 0) int tabId) {
        switch (tabId) {
            case 0:
                return new ManagementFragment();
            case 1:
            default:
                return new ManagementFragment();
        }
    }

    @Override
    public void startRootFragment() {
        selectTab(1);
    }

}
