package com.am.scheduling.presentation.screens.home.schedule.timeslotpicker;

import android.os.Bundle;

import com.am.scheduling.chapter5.Timetable;
import com.am.scheduling.domain.usecases.timeslot.TimeslotListCase;
import com.am.scheduling.presentation.abc.core.list.ListPresenter;
import com.am.scheduling.presentation.abc.core.list.ListView;
import com.am.scheduling.presentation.screens.home.schedule.timeslotpicker.adapter.CheckTimeslotDH;
import com.am.scheduling.presentation.utils.Consts;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public interface TimeslotPickerContract {

    interface View extends ListView<CheckTimeslotDH> {
        void startGeneratorScreen(Timetable timetable);
    }

    interface Presenter extends ListPresenter {
        void check(CheckTimeslotDH dh, int position);
        void next();
    }

    class Model {

        @Inject
        TimeslotListCase mCase;

        @Inject
        public Model() {
        }
    }

    @Module
    class TimeslotPickerModule {

        @Provides
        protected View provideView(TimeslotPickerFragment fragment) {
            return fragment;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model, Bundle args) {
            Timetable timetable = args.getParcelable(Consts.KEY_RESULT);
            return new TimeslotPickerPresenter(view, model, timetable);
        }

        @Provides
        protected Bundle provideArguments(TimeslotPickerFragment fragment) {
            return fragment.getArguments();
        }
    }

}