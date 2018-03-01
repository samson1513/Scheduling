package com.am.scheduling.presentation.screens.main.managment.group.create;

import com.am.scheduling.presentation.core.base.BasePresenter;
import com.am.scheduling.presentation.core.base.BaseView;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public interface CreateGroupContract {

    interface View extends BaseView<Presenter> {
        void finish();
    }

    interface Presenter extends BasePresenter<View> {
        void save(String name, String capacity);
    }
}
