package com.am.scheduling.domain.repositories.timeslot;

import com.am.scheduling.data.database.dao.TimeslotDao;
import com.am.scheduling.data.database.models.Timeslot;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class TimeslotRepoImpl implements TimeslotRepo {

    @Inject
    TimeslotDao mTimeslotDao;

    @Inject
    public TimeslotRepoImpl() {
    }

    @Override
    public Single<List<Timeslot>> get() {
        return Single.just(mTimeslotDao.get());
    }

    @Override
    public Completable save(List<Timeslot> group) {
        return Completable.fromAction(() -> mTimeslotDao.insert(group));
    }
}
