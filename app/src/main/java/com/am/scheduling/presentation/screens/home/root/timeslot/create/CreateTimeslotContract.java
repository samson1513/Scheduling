package com.am.scheduling.presentation.screens.home.root.timeslot.create;

import com.am.scheduling.domain.usecases.timeslot.CreateTimeslotCase;
import com.am.scheduling.presentation.abc.core.base.BasePresenter;
import com.am.scheduling.presentation.abc.core.base.BaseView;
import com.am.scheduling.presentation.screens.home.root.timeslot.create.adapter.day.DayDH;
import com.am.scheduling.presentation.screens.home.root.timeslot.create.adapter.slot.SlotDH;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public interface CreateTimeslotContract {

    interface View extends BaseView {
        void setDays(List<DayDH> days);
        void addSlot(SlotDH slotDH);
        void updateSlot(int position, SlotDH slotDH);
        void showTimePicker();
        void finish();
    }

    interface Presenter extends BasePresenter {
        void onPickStartTime(SlotDH slotDH, int position);
        void onPickEndTime(SlotDH slotDH, int position);
        void onTimePicked(Calendar time);
        void save(List<DayDH> days, List<SlotDH> slotDHS);
    }

    class Model {

        @Inject
        CreateTimeslotCase mCreateCase;

        @Inject
        public Model() {
        }
    }

    @Module
    class CreateTimeslotModule {

        @Provides
        protected View provideView(CreateTimeslotFragment fragment) {
            return fragment;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model) {
            return new CreateTimeslotPresenter(view, model);
        }
    }

}