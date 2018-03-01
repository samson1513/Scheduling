package com.am.scheduling.presentation.screens.main.managment;

import com.am.scheduling.presentation.core.base.BasePresenter;
import com.am.scheduling.presentation.core.base.BaseView;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public interface ManagementContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter<View> {

    }
}
