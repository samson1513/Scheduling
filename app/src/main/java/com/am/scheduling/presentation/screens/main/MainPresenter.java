package com.am.scheduling.presentation.screens.main;

import android.os.Bundle;

import com.am.scheduling.presentation.core.base.BasePresenterImpl;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class MainPresenter extends BasePresenterImpl<MainContract.View>
        implements MainContract.Presenter {

    @Inject
    public MainPresenter() {
    }

    @Override
    public void onViewReady(Bundle savedState) {
        if (savedState != null) {
            getView().startRootFragment();
        }
    }
}
