package com.am.scheduling.presentation.screens.main.managment.schedule.create;

import android.util.Pair;

import com.am.scheduling.data.database.models.Timeslot;
import com.am.scheduling.domain.base.completable.DefaultCompletableObserver;
import com.am.scheduling.domain.usecases.timeslot.CreateTimeslotCase;
import com.am.scheduling.presentation.core.base.BasePresenterImpl;
import com.am.scheduling.presentation.screens.main.managment.schedule.create.adapter.day.DayDH;
import com.am.scheduling.presentation.screens.main.managment.schedule.create.adapter.slot.SlotDH;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CreateSchedulePresenter extends BasePresenterImpl<CreateScheduleContract.View>
        implements CreateScheduleContract.Presenter {

    private CreateTimeslotCase mCreateCase;

    private List<DayDH> dayDHS;
    private Pair<Integer, SlotDH> targetSlot;
    private boolean forStart;

    @Inject
    public CreateSchedulePresenter(CreateTimeslotCase createTeacherCase) {
        mCreateCase = createTeacherCase;

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
    public void onViewReady() {
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
                    String uuid = UUID.randomUUID().toString();
                    for (DayDH day : days) {
                        int dayOfWeek = day.getDay().get(Calendar.DAY_OF_WEEK);
                        for (SlotDH slot : slots) {
                            Timeslot t = new Timeslot();
                            t.setScheduleId(uuid);

                            Calendar start = slot.getStartTime();
                            start.set(Calendar.DAY_OF_WEEK, dayOfWeek);
                            t.setStartTime(start.getTime());

                            Calendar end = slot.getEndTime();
                            end.set(Calendar.DAY_OF_WEEK, dayOfWeek);
                            t.setEndTime(end.getTime());

                            timeslots.add(t);
                        }
                    }
                    return timeslots;
                })
                .doOnSuccess(timeslots -> addDisposable(mCreateCase.with(timeslots).execute(new CreateObserver())))
                .doOnError(Throwable::printStackTrace)
                .subscribe()
        );
    }

    class CreateObserver extends DefaultCompletableObserver {

        @Override
        public void onComplete() {
            getView().finish();
        }
    }
}
