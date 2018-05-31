package com.am.scheduling.presentation.screens.main.creator;

import com.am.scheduling.presentation.core.base.BasePresenter;
import com.am.scheduling.presentation.core.base.BaseView;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public interface CreatorContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter<View> {

    }
}
