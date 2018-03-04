package com.am.scheduling.presentation.screens.main.managment.schedule;

import com.am.scheduling.domain.base.single.DefaultSingleObserver;
import com.am.scheduling.domain.usecases.timeslot.TimeslotListCase;
import com.am.scheduling.presentation.core.list.ListPresenterImpl;
import com.am.scheduling.presentation.screens.main.managment.schedule.adapter.ScheduleDH;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class SchedulesPresenter extends ListPresenterImpl<SchedulesContract.View>
        implements SchedulesContract.Presenter {

    private TimeslotListCase mTimeslotListCase;

    @Inject
    public SchedulesPresenter(TimeslotListCase roomListCase) {
        mTimeslotListCase = roomListCase;
    }

    @Override
    public void loadData() {
        addDisposable(mTimeslotListCase.execute(new ListObserver()));
    }

    @Override
    public void createSubject() {
        getView().startCreateSubjectScreen();
    }

    class ListObserver extends DefaultSingleObserver<List<ScheduleDH>> {

        @Override
        public void onSuccess(List<ScheduleDH> roomDHS) {
            getView().setItems(roomDHS);
        }
    }
}
