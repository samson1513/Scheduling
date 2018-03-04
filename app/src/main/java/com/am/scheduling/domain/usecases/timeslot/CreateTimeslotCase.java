package com.am.scheduling.domain.usecases.timeslot;

import com.am.scheduling.data.database.models.Timeslot;
import com.am.scheduling.domain.base.completable.CompletableAsyncUseCase;
import com.am.scheduling.domain.repositories.timeslot.TimeslotRepo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CreateTimeslotCase extends CompletableAsyncUseCase {

    @Inject
    TimeslotRepo mTimeslotRepo;
    private Timeslot[] mTimeslots;

    @Inject
    public CreateTimeslotCase() {
    }

    public CreateTimeslotCase with(List<Timeslot> slots) {
        mTimeslots = new Timeslot[slots.size()];
        slots.toArray(mTimeslots);
        return this;
    }

    @Override
    protected Completable buildTask() {
        return mTimeslotRepo.save(mTimeslots);
    }
}
