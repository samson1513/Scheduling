package com.am.scheduling.presentation.screens.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.content.ContentActivity;
import com.am.scheduling.presentation.screens.home.root.RootFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeActivity extends ContentActivity<HomeContract.Presenter> implements HomeContract.View {


    public static Intent newLaunchIntent(Context context) {
        return new Intent(context, HomeActivity.class);
    }

    @BindView(R.id.toolbar_ah)
    Toolbar mToolbarAh;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_home;
    }

    @Override
    protected void initUtils() {
        setSupportActionBar(mToolbarAh);
        super.initUtils();
    }

    @Override
    protected void initUI() {
        if (getNavigator().getCountFragmentsInBackStack() == 0) {
            getPresenter().subscribe();
        }

        getSupportFragmentManager().addOnBackStackChangedListener(this::onBackstackChange);
    }

    @Override
    protected void onDestroy() {
        getSupportFragmentManager().removeOnBackStackChangedListener(this::onBackstackChange);
        super.onDestroy();
    }

    private void onBackstackChange() {
        if (getNavigator().getCountFragmentsInBackStack() > 1) {
            getToolbarManager().showHomeButton();
        } else {
            getToolbarManager().hideHomeButton();
        }
    }

    @Override
    public int getContainerRes() {
        return R.id.container_ah;
    }

    @Override
    public void startRootFragment() {
        getNavigator().switchFragment(RootFragment.newInstance());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }
}

