package com.am.scheduling.domain.usecases.timeslot;

import com.am.scheduling.data.database.models.Timeslot;
import com.am.scheduling.domain.base.input.CompletableCase;
import com.am.scheduling.domain.repositories.timeslot.TimeslotRepo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CreateTimeslotCase extends CompletableCase<List<Timeslot>> {

    @Inject
    TimeslotRepo repo;

    @Inject
    public CreateTimeslotCase() {
    }

    @Override
    protected Completable buildTask(List<Timeslot> data) {
        return repo.save(data);
    }
}
