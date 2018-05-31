package com.am.scheduling.domain.usecases.timeslot;

import com.am.scheduling.data.database.models.Timeslot;
import com.am.scheduling.domain.base.no_input.NoInputSingleCase;
import com.am.scheduling.domain.repositories.timeslot.TimeslotRepo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class TimeslotListCase extends NoInputSingleCase<List<Timeslot>> {

    @Inject
    TimeslotRepo repo;

    @Inject
    public TimeslotListCase() {
    }

    @Override
    protected Single<List<Timeslot>> buildTask() {
        return repo.get();
    }
}
