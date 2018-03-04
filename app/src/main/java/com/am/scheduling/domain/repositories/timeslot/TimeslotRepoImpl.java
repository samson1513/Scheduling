package com.am.scheduling.domain.repositories.timeslot;

import com.am.scheduling.data.database.dao.TimeslotDao;
import com.am.scheduling.data.database.models.Timeslot;
import com.am.scheduling.presentation.screens.main.managment.schedule.adapter.ScheduleDH;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class TimeslotRepoImpl implements TimeslotRepo {

    private TimeslotDao mTimeslotDao;
    private TimeslotMapper mTimeslotMapper;

    @Inject
    public TimeslotRepoImpl(TimeslotDao roomDao, TimeslotMapper timeslotMapper) {
        mTimeslotDao = roomDao;
        mTimeslotMapper = timeslotMapper;
    }

    @Override
    public Single<List<ScheduleDH>> get() {
        return mTimeslotDao.get()
                .flatMapObservable(Observable::fromIterable)
                .groupBy(Timeslot::getScheduleId)
                .flatMapSingle(groups -> groups.collect(ArrayList<Timeslot>::new, ArrayList<Timeslot>::add))
                .map(mTimeslotMapper::convert)
                .toList();
    }

    @Override
    public Completable save(Timeslot... group) {
        return Completable.fromCallable(() -> mTimeslotDao.insert(group));
    }
}
