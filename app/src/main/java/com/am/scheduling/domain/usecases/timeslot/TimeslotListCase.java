package com.am.scheduling.domain.usecases.timeslot;

import com.am.scheduling.domain.base.single.SingleAsyncUseCase;
import com.am.scheduling.domain.repositories.timeslot.TimeslotRepo;
import com.am.scheduling.presentation.screens.main.managment.schedule.adapter.ScheduleDH;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class TimeslotListCase extends SingleAsyncUseCase<List<ScheduleDH>> {

    @Inject
    TimeslotRepo mTimeslotRepo;

    @Inject
    public TimeslotListCase() {
    }

    @Override
    protected Single<List<ScheduleDH>> buildTask() {
        return mTimeslotRepo.get();
    }
}
