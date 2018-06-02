package com.am.scheduling.domain.repositories.app;

import io.reactivex.Completable;

/**
 * Created by Alex Michenko
 * on 02.06.2018.
 */
public interface AppRepo {

    Completable fill();
}
