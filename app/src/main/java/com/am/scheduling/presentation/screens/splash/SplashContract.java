package com.am.scheduling.presentation.screens.splash;


import com.am.scheduling.presentation.core.base.BasePresenter;
import com.am.scheduling.presentation.core.base.BaseView;
import com.am.scheduling.presentation.utils.authentication.AuthHelper;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 08.02.2018.
 */

public interface SplashContract {

    interface View extends BaseView<Presenter> {
        void startMainScreen();
    }

    interface Presenter extends BasePresenter<View> {
        void onUiReady();
    }
}
