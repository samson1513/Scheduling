package com.am.scheduling.presentation.screens.home.root.management;

import com.am.scheduling.presentation.abc.core.base.BasePresenter;
import com.am.scheduling.presentation.abc.core.base.BaseView;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public interface ManagementContract {

    interface View extends BaseView {
        void startRoomsScreen();

        void startGroupsScreen();

        void startTeachersScreen();

        void startSubjectsScreen();

        void startSchedulesScreen();
    }

    interface Presenter extends BasePresenter {

        void openRoomsScreen();

        void openGroupsScreen();

        void openTeachersScreen();

        void openSubjectsScreen();

        void openSchedulesScreen();
    }

    class Model {

        @Inject
        public Model() {
        }
    }

    @Module
    class ManagementModule {

        @Provides
        protected View provideView(ManagementFragment fragment) {
            return fragment;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model) {
            return new ManagementPresenter(view, model);
        }
    }

}