package com.am.scheduling.presentation.screens.splash;

import android.content.Intent;
import android.os.Bundle;

import com.am.scheduling.R;
import com.am.scheduling.presentation.core.base.BaseActivity;
import com.am.scheduling.presentation.core.base.toolbar.ToolbarAdapter;
import com.am.scheduling.presentation.screens.main.MainActivity;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public class SplashActivity extends BaseActivity<SplashContract.Presenter>
        implements SplashContract.View {

    @Override
    protected ToolbarAdapter getToolbarAdapter() {
        return null;
    }

    @Inject
    SplashContract.Presenter presenter;

    @Override
    public SplashContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        getPresenter().onUiReady();
    }


    @Override
    public void startMainScreen() {
        getNavigator().startActivity(this, MainActivity.newLaunchIntent(this));
    }
}
