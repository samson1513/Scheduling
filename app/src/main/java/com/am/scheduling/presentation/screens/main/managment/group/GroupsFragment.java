package com.am.scheduling.presentation.screens.main.managment.group;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.am.scheduling.presentation.core.list.ListFragment;
import com.am.scheduling.presentation.core.list.adapter.SimpleAdapter;
import com.am.scheduling.presentation.screens.main.managment.group.adapter.GroupDH;
import com.am.scheduling.presentation.screens.main.managment.group.adapter.GroupsAdapter;
import com.am.scheduling.presentation.screens.main.managment.group.create.CreateGroupFragment;
import com.am.scheduling.presentation.utils.Consts;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class GroupsFragment extends ListFragment<GroupDH, GroupsContract.Presenter>
        implements GroupsContract.View {

    @Inject
    GroupsContract.Presenter mPresenter;

    @Inject
    GroupsAdapter mAdapter;

    @Override
    public GroupsContract.Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected SimpleAdapter<GroupDH> getAdapter() {
        return mAdapter;
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState) {
        getPresenter().loadData();
    }

    @Override
    public void startCreateGroupScreen() {
        getNavigator().showFragment(new CreateGroupFragment());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Consts.RC_CREATE) {
            getPresenter().createGroup();
        }
    }
}
