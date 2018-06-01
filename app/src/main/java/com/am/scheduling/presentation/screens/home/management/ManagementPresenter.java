package com.am.scheduling.presentation.screens.home.management;

import com.am.scheduling.presentation.abc.core.base.BasePresenterImpl;

public class ManagementPresenter extends BasePresenterImpl<ManagementContract.View> implements ManagementContract.Presenter {

    private ManagementContract.Model model;

    public ManagementPresenter(ManagementContract.View view, ManagementContract.Model model) {
        super(view);
        this.model = model;
    }

    @Override
    public void openRoomsScreen() {
        getView().startRoomsScreen();
    }

    @Override
    public void openGroupsScreen() {
        getView().startGroupsScreen();
    }

    @Override
    public void openTeachersScreen() {
        getView().startTeachersScreen();
    }

    @Override
    public void openSubjectsScreen() {
        getView().startSubjectsScreen();
    }

    @Override
    public void openSchedulesScreen() {
        getView().startSchedulesScreen();
    }

    @Override
    public void subscribe() {

    }
}