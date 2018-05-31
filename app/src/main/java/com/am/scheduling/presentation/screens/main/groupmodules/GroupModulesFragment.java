package com.am.scheduling.presentation.screens.main.groupmodules;

import android.os.Bundle;


public class GroupModulesFragment extends BaseFragment<GroupModulesContract.Presenter> implements GroupModulesContract.View {

    public static GroupModulesFragment newInstance() {
        GroupModulesFragment fragment = new GroupModulesFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_groupmodules;
    }
}

