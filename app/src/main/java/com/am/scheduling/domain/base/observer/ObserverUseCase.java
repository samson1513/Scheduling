package com.am.scheduling.domain.base.observer;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Alex Michenko
 * on 12.01.2018.
 */

public abstract class ObserverUseCase<Data> {

    protected abstract Observable<Data> buildTask();

    public <T extends DisposableObserver<Data>> T execute(final T observer) {
        return buildTask().subscribeWith(observer);
    }
}
