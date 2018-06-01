package com.am.scheduling.presentation.screens.home.management.timeslot.create;

import android.util.Pair;

import com.am.scheduling.data.database.models.Timeslot;
import com.am.scheduling.presentation.abc.core.base.BasePresenterImpl;
import com.am.scheduling.presentation.screens.home.management.timeslot.create.adapter.day.DayDH;
import com.am.scheduling.presentation.screens.home.management.timeslot.create.adapter.slot.SlotDH;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public class CreateTimeslotPresenter extends BasePresenterImpl<CreateTimeslotContract.View> implements CreateTimeslotContract.Presenter {

    private CreateTimeslotContract.Model model;

    private List<DayDH> dayDHS;
    private Pair<Integer, SlotDH> targetSlot;
    private boolean forStart;

    public CreateTimeslotPresenter(CreateTimeslotContract.View view, CreateTimeslotContract.Model model) {
        super(view);
        this.model = model;

        dayDHS = new ArrayList<>();
        dayDHS.add(new DayDH(Calendar.SUNDAY));
        dayDHS.add(new DayDH(Calendar.MONDAY));
        dayDHS.add(new DayDH(Calendar.TUESDAY));
        dayDHS.add(new DayDH(Calendar.WEDNESDAY));
        dayDHS.add(new DayDH(Calendar.THURSDAY));
        dayDHS.add(new DayDH(Calendar.FRIDAY));
        dayDHS.add(new DayDH(Calendar.SATURDAY));
    }

    @Override
    public void subscribe() {
        getView().setDays(dayDHS);
        getView().addSlot(new SlotDH());
    }

    @Override
    public void onPickStartTime(SlotDH slotDH, int position) {
        targetSlot = Pair.create(position, slotDH);
        forStart = true;
        getView().showTimePicker();
    }

    @Override
    public void onPickEndTime(SlotDH slotDH, int position) {
        targetSlot = Pair.create(position, slotDH);
        forStart = false;
        getView().showTimePicker();
    }

    @Override
    public void onTimePicked(Calendar time) {
        if (targetSlot != null) {
            boolean isNew;
            if (forStart) {
                isNew = targetSlot.second.getStartTime() == null;
                targetSlot.second.setStartTime(time);
            } else {
                isNew = targetSlot.second.getEndTime() == null;
                targetSlot.second.setEndTime(time);
            }
            getView().updateSlot(targetSlot.first, targetSlot.second);

            if (isNew
                    && targetSlot.second.getStartTime() != null
                    && targetSlot.second.getEndTime() != null) {
                getView().addSlot(new SlotDH());
            }
        }
    }

    @Override
    public void save(List<DayDH> dayDhs, List<SlotDH> slotDhs) {
        addDisposable(Single.zip(Observable.fromIterable(dayDhs)
                        .filter(DayDH::isSelected)
                        .toList(),
                Observable.fromIterable(slotDhs)
                        .filter(slotDH -> slotDH.getStartTime() != null && slotDH.getEndTime() != null)
                        .toList(),
                (days, slots) -> {
                    List<Timeslot> timeslots = new ArrayList<>();
                    for (DayDH day : days) {
                        int dayOfWeek = day.getDay().get(Calendar.DAY_OF_WEEK);
                        for (SlotDH slot : slots) {
                            Timeslot t = new Timeslot();

                            Calendar start = slot.getStartTime();
                            start.set(Calendar.DAY_OF_WEEK, dayOfWeek);
                            t.startTime = start.getTime();

                            Calendar end = slot.getEndTime();
                            end.set(Calendar.DAY_OF_WEEK, dayOfWeek);
                            t.endTime = end.getTime();

                            timeslots.add(t);
                        }
                    }
                    return timeslots;
                })
                .flatMapCompletable(timeslots -> model.mCreateCase.async(timeslots))
                .subscribe(getView()::finish, Throwable::printStackTrace)
        );
    }
}