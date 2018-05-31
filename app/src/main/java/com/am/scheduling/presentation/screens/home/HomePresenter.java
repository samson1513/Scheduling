package com.am.scheduling.presentation.screens.home;

import com.am.scheduling.presentation.abc.core.base.BasePresenterImpl;

public class HomePresenter extends BasePresenterImpl<HomeContract.View> implements HomeContract.Presenter {

    private HomeContract.Model model;

    public HomePresenter(HomeContract.View view, HomeContract.Model model) {
        super(view);
        this.model = model;
    }

    @Override
    public void subscribe() {
        getView().startRootFragment();
    }
}