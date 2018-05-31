package com.am.scheduling.presentation.screens.splash;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.base.BaseActivity;
import com.am.scheduling.presentation.screens.home.HomeActivity;


public class SplashActivity extends BaseActivity<SplashContract.Presenter> implements SplashContract.View {


    @Override
    protected int getLayoutResource() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initUI() {
        getPresenter().subscribe();
    }

    @Override
    public void startMainScreen() {
        startActivity(HomeActivity.newLaunchIntent(this));
    }
}