package com.am.scheduling.presentation.screens.home;

import com.am.scheduling.presentation.abc.core.base.BasePresenter;
import com.am.scheduling.presentation.abc.core.base.BaseView;
import com.am.scheduling.presentation.abc.core.navigator.Nav;
import com.am.scheduling.presentation.abc.core.navigator.NavImpl;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public interface HomeContract {

    interface View extends BaseView {
        void startRootFragment();
    }

    interface Presenter extends BasePresenter {

    }

    class Model {

        @Inject
        public Model() {
        }
    }

    @Module
    class HomeModule {

        @Provides
        protected Nav provideNav(HomeActivity activity) {
            return new NavImpl(activity);
        }

        @Provides
        protected View provideView(HomeActivity activity) {
            return activity;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model) {
            return new HomePresenter(view, model);
        }
    }

}