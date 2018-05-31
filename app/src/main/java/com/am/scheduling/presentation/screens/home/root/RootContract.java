package com.am.scheduling.presentation.screens.home.root;

import com.am.scheduling.presentation.abc.core.base.BasePresenter;
import com.am.scheduling.presentation.abc.core.base.BaseView;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public interface RootContract {

    interface View extends BaseView {
        void startManagementScreen();
        void startGeneratorScreen();
    }

    interface Presenter extends BasePresenter {
        void openManagementScreen();
        void openGeneratorScreen();
    }

    class Model {

        @Inject
        public Model() {
        }
    }

    @Module
    class RootModule {

        @Provides
        protected View provideView(RootFragment fragment) {
            return fragment;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model) {
            return new RootPresenter(view, model);
        }
    }

}