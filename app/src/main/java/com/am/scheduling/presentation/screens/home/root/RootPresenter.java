package com.am.scheduling.presentation.screens.home.root;

import com.am.scheduling.presentation.abc.core.base.BasePresenterImpl;

public class RootPresenter extends BasePresenterImpl<RootContract.View> implements RootContract.Presenter {

    private RootContract.Model model;

    public RootPresenter(RootContract.View view, RootContract.Model model) {
        super(view);
        this.model = model;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void openManagementScreen() {
        getView().startManagementScreen();
    }

    @Override
    public void openGeneratorScreen() {
        getView().startGeneratorScreen();
    }
}