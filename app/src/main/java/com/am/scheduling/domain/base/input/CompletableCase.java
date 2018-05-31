package com.am.scheduling.domain.base.input;


import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alex Michenko
 * on 26.04.2018.
 */
public abstract class CompletableCase<In> {

    protected abstract Completable buildTask(In data);

    public Completable sync(In data) {
        return buildTask(data);
    }

    public Completable async(In data) {
        return buildTask(data)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
