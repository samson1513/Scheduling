package com.am.scheduling.presentation.screens.main;

import android.os.Bundle;

import com.am.scheduling.presentation.core.base.BasePresenter;
import com.am.scheduling.presentation.core.base.BaseView;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public interface MainContract {

    interface View extends BaseView<Presenter> {
        void startRootFragment();
    }

    interface Presenter extends BasePresenter<View> {
        void onViewReady(Bundle savedState);
    }

}
