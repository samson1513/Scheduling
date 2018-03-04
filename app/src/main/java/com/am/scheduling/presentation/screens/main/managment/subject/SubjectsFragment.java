package com.am.scheduling.presentation.screens.main.managment.subject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.am.scheduling.presentation.core.list.ListFragment;
import com.am.scheduling.presentation.core.list.adapter.SimpleAdapter;
import com.am.scheduling.presentation.screens.main.managment.subject.adapter.SubjectDH;
import com.am.scheduling.presentation.screens.main.managment.subject.adapter.SubjectsAdapter;
import com.am.scheduling.presentation.screens.main.managment.subject.create.CreateSubjectFragment;
import com.am.scheduling.presentation.utils.Consts;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class SubjectsFragment extends ListFragment<SubjectDH, SubjectsContract.Presenter>
        implements SubjectsContract.View {

    @Inject
    SubjectsContract.Presenter mPresenter;

    @Inject
    SubjectsAdapter mAdapter;

    @Override
    public SubjectsContract.Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected SimpleAdapter<SubjectDH> getAdapter() {
        return mAdapter;
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState) {
        getPresenter().loadData();
    }

    @Override
    public void startCreateSubjectScreen() {
        getNavigator().showFragment(new CreateSubjectFragment());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Consts.RC_CREATE) {
            getPresenter().createSubject();
        }
    }
}
