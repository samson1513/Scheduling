package com.am.scheduling.presentation.screens.main.managment.subject;

import com.am.scheduling.presentation.core.list.ListPresenter;
import com.am.scheduling.presentation.core.list.ListView;
import com.am.scheduling.presentation.screens.main.managment.subject.adapter.SubjectDH;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public interface SubjectsContract {

    interface View extends ListView<SubjectDH, Presenter> {
        void startCreateSubjectScreen();
    }

    interface Presenter extends ListPresenter<View> {
        void createSubject();
    }
}
