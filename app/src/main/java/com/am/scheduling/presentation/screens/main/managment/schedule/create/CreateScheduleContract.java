package com.am.scheduling.presentation.screens.main.managment.schedule.create;

import com.am.scheduling.presentation.core.base.BasePresenter;
import com.am.scheduling.presentation.core.base.BaseView;
import com.am.scheduling.presentation.screens.main.managment.schedule.create.adapter.day.DayDH;
import com.am.scheduling.presentation.screens.main.managment.schedule.create.adapter.slot.SlotDH;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public interface CreateScheduleContract {

    interface View extends BaseView<Presenter> {
        void setDays(List<DayDH> days);
        void addSlot(SlotDH slotDH);
        void updateSlot(int position, SlotDH slotDH);
        void showTimePicker();
        void finish();
    }

    interface Presenter extends BasePresenter<View> {
        void onViewReady();
        void onPickStartTime(SlotDH slotDH, int position);
        void onPickEndTime(SlotDH slotDH, int position);
        void onTimePicked(Calendar time);
        void save(List<DayDH> days, List<SlotDH> slotDHS);
    }
}
