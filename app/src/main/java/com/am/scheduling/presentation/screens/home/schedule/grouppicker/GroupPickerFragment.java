package com.am.scheduling.presentation.screens.home.schedule.grouppicker;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.am.scheduling.R;
import com.am.scheduling.data.database.models.Group;
import com.am.scheduling.presentation.abc.core.list.ListFragment;
import com.am.scheduling.presentation.abc.core.list.adapter.SimpleAdapter;
import com.am.scheduling.presentation.screens.home.schedule.grouppicker.adapter.CheckGroupDH;
import com.am.scheduling.presentation.screens.home.schedule.grouppicker.adapter.CheckGroupsAdapter;
import com.am.scheduling.presentation.screens.home.schedule.modules.ModulesFragment;
import com.am.scheduling.presentation.utils.ui.RxView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;


public class GroupPickerFragment extends ListFragment<CheckGroupDH, GroupPickerContract.Presenter> implements GroupPickerContract.View {


    public static GroupPickerFragment newInstance() {
        GroupPickerFragment fragment = new GroupPickerFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @BindView(R.id.rv_bfl_list)
    RecyclerView mRvBflList;
    @BindView(R.id.btn_next)
    Button mBtnNext;

    @Inject
    CheckGroupsAdapter adapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_group_picker;
    }

    @Override
    public void initUI() {
        adapter.setOnItemClickListener((adapter1, view, position) ->
                getPresenter().check(adapter.getItem(position), position)
        );

        RxView.safeClicks(mBtnNext)
                .subscribe(o -> getPresenter().next());

        getPresenter().subscribe();
    }

    @Override
    public SimpleAdapter<CheckGroupDH> getAdapter() {
        return adapter;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return mRvBflList;
    }

    @Override
    public void startModulesScreen(ArrayList<Group> checkedGroups) {
        getNavigator().switchFragment(ModulesFragment.newInstance(checkedGroups));
    }
}

