package com.am.scheduling.domain.usecases.app;

import com.am.scheduling.domain.base.no_input.NoInputCompletableCase;
import com.am.scheduling.domain.repositories.app.AppRepo;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by Alex Michenko
 * on 02.06.2018.
 */
public class AppCase extends NoInputCompletableCase {

    @Inject
    AppRepo repo;

    @Inject
    public AppCase() {
    }

    @Override
    protected Completable buildTask() {
        return repo.fill();
    }
}
