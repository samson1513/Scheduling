package com.am.scheduling.presentation.screens.main.managment.schedule;

import com.am.scheduling.presentation.core.list.ListPresenter;
import com.am.scheduling.presentation.core.list.ListView;
import com.am.scheduling.presentation.screens.main.managment.schedule.adapter.ScheduleDH;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public interface SchedulesContract {

    interface View extends ListView<ScheduleDH, Presenter> {
        void startCreateSubjectScreen();
    }

    interface Presenter extends ListPresenter<View> {
        void createSubject();
    }
}
