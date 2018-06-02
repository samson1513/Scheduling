package com.am.scheduling.presentation.screens.home.schedule.timeslotpicker;

import com.am.scheduling.chapter5.Timetable;
import com.am.scheduling.data.database.models.Timeslot;
import com.am.scheduling.presentation.abc.core.list.ListPresenterImpl;
import com.am.scheduling.presentation.screens.home.schedule.timeslotpicker.adapter.CheckTimeslotDH;
import com.am.scheduling.presentation.utils.DateUtil;

import java.util.ArrayList;

import io.reactivex.Observable;

public class TimeslotPickerPresenter extends ListPresenterImpl<TimeslotPickerContract.View> implements TimeslotPickerContract.Presenter {

    private TimeslotPickerContract.Model model;
    private ArrayList<Timeslot> checkedSlots;
    private Timetable timetable;

    public TimeslotPickerPresenter(TimeslotPickerContract.View view, TimeslotPickerContract.Model model, Timetable timetable) {
        super(view);
        this.model = model;
        this.timetable = new Timetable(timetable);
        checkedSlots = new ArrayList<>();
    }

    @Override
    public void subscribe() {
        addDisposable(model.mCase.async()
                .flatMapObservable(Observable::fromIterable)
                .map(CheckTimeslotDH::new)
                .map(timeslotDH -> {
                    timeslotDH.checked = getIndex(timeslotDH.model) != -1;
                    return timeslotDH;
                })
                .toList()
                .subscribe(getView()::setItems, Throwable::printStackTrace)
        );
    }

    @Override
    public void check(CheckTimeslotDH dh, int position) {
        boolean checked = !dh.checked;
        if (checked) {
            checkedSlots.add(dh.model);
        } else {
            checkedSlots.remove(dh.model);
        }
        dh.checked = checked;
        getView().updateItem(dh, position);
    }

    @Override
    public void next() {
        if (!checkedSlots.isEmpty()) {
            getView().startGeneratorScreen(prepareTimetable());
        } else {
            getView().showMessage("Select time intervals");
        }
    }

    @Override
    public void loadMore() {

    }

    private int getIndex(Timeslot group) {
        for (int i = 0; i < checkedSlots.size(); i++) {
            if (checkedSlots.get(i).id == group.id) {
                return i;
            }
        }
        return -1;
    }

    private Timetable prepareTimetable() {
        Timetable timetable = new Timetable(this.timetable);
        for (Timeslot slot : checkedSlots) {
            String start = DateUtil.toString(slot.startTime, DateUtil.PATTERN_WEEK_DAY_TIME);
            String end = DateUtil.toString(slot.endTime, DateUtil.PATTERN_TIME);
            String time = String.format("%s - %s", start, end);
            timetable.addTimeslot(slot.id, time);
        }
        return timetable;
    }
}