package com.am.scheduling.domain.base.no_input;


import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alex Michenko
 * on 26.04.2018.
 */
public abstract class NoInputCompletableCase {

    protected abstract Completable buildTask();

    public Completable sync() {
        return buildTask();
    }

    public Completable async() {
        return buildTask()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
