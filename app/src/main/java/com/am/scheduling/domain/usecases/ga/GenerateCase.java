package com.am.scheduling.domain.usecases.ga;

import com.am.scheduling.chapter5.Timetable;
import com.am.scheduling.domain.base.input.SingleCase;
import com.am.scheduling.domain.repositories.ga.GenRepo;

import java.io.File;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 01.06.2018.
 */
public class GenerateCase extends SingleCase<Timetable, File> {

    @Inject
    GenRepo repo;

    @Inject
    public GenerateCase() {
    }

    @Override
    protected Single<File> buildTask(Timetable data) {
        return repo.generate(data);
    }
}
