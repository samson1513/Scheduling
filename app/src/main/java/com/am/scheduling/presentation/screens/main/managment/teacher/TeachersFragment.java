package com.am.scheduling.presentation.screens.main.managment.teacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.am.scheduling.presentation.core.list.ListFragment;
import com.am.scheduling.presentation.core.list.adapter.SimpleAdapter;
import com.am.scheduling.presentation.screens.main.managment.teacher.adapter.TeacherDH;
import com.am.scheduling.presentation.screens.main.managment.teacher.adapter.TeachersAdapter;
import com.am.scheduling.presentation.screens.main.managment.teacher.create.CreateTeacherFragment;
import com.am.scheduling.presentation.utils.Consts;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class TeachersFragment extends ListFragment<TeacherDH, TeachersContract.Presenter>
        implements TeachersContract.View {

    @Inject
    TeachersContract.Presenter mPresenter;

    @Inject
    TeachersAdapter mAdapter;

    @Override
    public TeachersContract.Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected SimpleAdapter<TeacherDH> getAdapter() {
        return mAdapter;
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState) {
        getPresenter().loadData();
    }

    @Override
    public void startCreateTeacherScreen() {
        getNavigator().showFragment(new CreateTeacherFragment());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Consts.RC_CREATE) {
            getPresenter().createTeacher();
        }
    }
}
