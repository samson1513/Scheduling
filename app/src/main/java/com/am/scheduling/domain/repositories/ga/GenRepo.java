package com.am.scheduling.domain.repositories.ga;

import com.am.scheduling.chapter5.Timetable;

import java.io.File;

import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 01.06.2018.
 */
public interface GenRepo {

    Single<File> generate(Timetable timetable);
}
