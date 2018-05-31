package com.am.scheduling.presentation.screens.main.groupmodules;

public class GroupModulesPresenter extends BasePresenterImpl<GroupModulesContract.View> implements GroupModulesContract.Presenter {

    private GroupModulesContract.Model model;

    public GroupModulesPresenter(GroupModulesContract.View view, GroupModulesContract.Model model) {
        super(view);
        this.model = model;
    }

}