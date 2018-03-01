package com.am.scheduling.domain.base.completable;

import io.reactivex.Completable;
import io.reactivex.observers.DisposableCompletableObserver;

/**
 * Created by Alex Michenko
 * on 12.01.2018.
 */

public abstract class CompletableUseCase {

    protected abstract Completable buildTask();

    public <T extends DisposableCompletableObserver> T execute(final T observer) {
        return buildTask().subscribeWith(observer);
    }
}
