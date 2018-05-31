package com.am.scheduling.presentation.screens.splash;

import com.am.scheduling.presentation.abc.core.base.BasePresenter;
import com.am.scheduling.presentation.abc.core.base.BaseView;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public interface SplashContract {

    interface View extends BaseView {
        void startMainScreen();
    }

    interface Presenter extends BasePresenter {

    }

    class Model {

        @Inject
        public Model() {
        }
    }

    @Module
    class SplashModule {

        @Provides
        protected View provideView(SplashActivity activity) {
            return activity;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model) {
            return new SplashPresenter(view, model);
        }
    }

}