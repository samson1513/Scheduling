package com.am.scheduling.domain.repositories.timeslot;

import com.am.scheduling.data.database.models.Timeslot;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public interface TimeslotRepo {

    Single<List<Timeslot>> get();

    Completable save(List<Timeslot> model);
}
