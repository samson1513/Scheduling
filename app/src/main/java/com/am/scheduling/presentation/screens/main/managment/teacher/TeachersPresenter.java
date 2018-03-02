package com.am.scheduling.presentation.screens.main.managment.teacher;

import com.am.scheduling.domain.base.single.DefaultSingleObserver;
import com.am.scheduling.domain.usecases.teacher.TeacherListCase;
import com.am.scheduling.presentation.core.list.ListPresenterImpl;
import com.am.scheduling.presentation.screens.main.managment.teacher.adapter.TeacherDH;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class TeachersPresenter extends ListPresenterImpl<TeachersContract.View>
        implements TeachersContract.Presenter {

    private TeacherListCase mTeacherListCase;

    @Inject
    public TeachersPresenter(TeacherListCase roomListCase) {
        mTeacherListCase = roomListCase;
    }

    @Override
    public void loadData() {
        addDisposable(mTeacherListCase.execute(new TeachersObserver()));
    }

    @Override
    public void createTeacher() {
        getView().startCreateTeacherScreen();
    }

    class TeachersObserver extends DefaultSingleObserver<List<TeacherDH>> {

        @Override
        public void onSuccess(List<TeacherDH> roomDHS) {
            getView().setItems(roomDHS);
        }
    }
}
