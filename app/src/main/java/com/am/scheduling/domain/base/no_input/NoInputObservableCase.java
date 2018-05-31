package com.am.scheduling.domain.base.no_input;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alex Michenko
 * on 26.04.2018.
 */
public abstract class NoInputObservableCase<Out> {

    protected abstract Observable<Out> buildTask();

    public Observable<Out> sync() {
        return buildTask();
    }

    public Observable<Out> async() {
        return buildTask()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
