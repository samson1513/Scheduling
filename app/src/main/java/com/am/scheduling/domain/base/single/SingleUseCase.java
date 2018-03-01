package com.am.scheduling.domain.base.single;

import io.reactivex.Single;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by Alex Michenko
 * on 12.01.2018.
 */

public abstract class SingleUseCase<Data> {

    protected abstract Single<Data> buildTask();

    public <T extends DisposableSingleObserver<Data>> T execute(final T observer) {
        return buildTask().subscribeWith(observer);
    }
}
