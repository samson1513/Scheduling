package com.am.scheduling.presentation.screens.main.managment.schedule;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.am.scheduling.presentation.core.list.ListFragment;
import com.am.scheduling.presentation.core.list.adapter.SimpleAdapter;
import com.am.scheduling.presentation.screens.main.managment.schedule.adapter.ScheduleDH;
import com.am.scheduling.presentation.screens.main.managment.schedule.adapter.SchedulesAdapter;
import com.am.scheduling.presentation.screens.main.managment.schedule.create.CreateScheduleFragment;
import com.am.scheduling.presentation.utils.Consts;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class SchedulesFragment extends ListFragment<ScheduleDH, SchedulesContract.Presenter>
        implements SchedulesContract.View {

    @Inject
    SchedulesContract.Presenter mPresenter;

    @Inject
    SchedulesAdapter mAdapter;

    @Override
    public SchedulesContract.Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected SimpleAdapter<ScheduleDH> getAdapter() {
        return mAdapter;
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState) {
        getPresenter().loadData();
    }

    @Override
    public void startCreateSubjectScreen() {
        getNavigator().showFragment(new CreateScheduleFragment());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Consts.RC_CREATE) {
            getPresenter().createSubject();
        }
    }
}
