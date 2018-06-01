package com.am.scheduling.presentation.screens.home.management.timeslot.list;

import com.am.scheduling.domain.usecases.timeslot.TimeslotListCase;
import com.am.scheduling.presentation.abc.core.list.ListPresenter;
import com.am.scheduling.presentation.abc.core.list.ListView;
import com.am.scheduling.presentation.screens.home.management.timeslot.list.adapter.TimeslotDH;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public interface TimeslotListContract {

    interface View extends ListView<TimeslotDH> {
        void startCreateScreen();
    }

    interface Presenter extends ListPresenter {
        void create();
    }

    class Model {

        @Inject
        TimeslotListCase mCase;

        @Inject
        public Model() {
        }
    }

    @Module
    class TimeslotListModule {

        @Provides
        protected View provideView(TimeslotListFragment fragment) {
            return fragment;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model) {
            return new TimeslotListPresenter(view, model);
        }
    }

}