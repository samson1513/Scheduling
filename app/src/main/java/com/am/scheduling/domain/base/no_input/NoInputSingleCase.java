package com.am.scheduling.domain.base.no_input;


import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alex Michenko
 * on 26.04.2018.
 */
public abstract class NoInputSingleCase<Out> {

    protected abstract Single<Out> buildTask();

    public Single<Out> sync() {
        return buildTask();
    }

    public Single<Out> async() {
        return buildTask()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
