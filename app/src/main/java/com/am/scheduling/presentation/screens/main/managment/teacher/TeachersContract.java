package com.am.scheduling.presentation.screens.main.managment.teacher;

import com.am.scheduling.presentation.core.list.ListPresenter;
import com.am.scheduling.presentation.core.list.ListView;
import com.am.scheduling.presentation.screens.main.managment.teacher.adapter.TeacherDH;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public interface TeachersContract {

    interface View extends ListView<TeacherDH, Presenter> {
        void startCreateTeacherScreen();
    }

    interface Presenter extends ListPresenter<View> {
        void createTeacher();
    }
}
