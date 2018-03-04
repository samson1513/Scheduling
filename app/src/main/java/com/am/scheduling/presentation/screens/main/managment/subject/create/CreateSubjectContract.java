package com.am.scheduling.presentation.screens.main.managment.subject.create;

import com.am.scheduling.presentation.core.base.BasePresenter;
import com.am.scheduling.presentation.core.base.BaseView;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public interface CreateSubjectContract {

    interface View extends BaseView<Presenter> {
        void finish();
    }

    interface Presenter extends BasePresenter<View> {
        void save(String name);
    }
}
