package com.am.scheduling.domain.base.input;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alex Michenko
 * on 26.04.2018.
 */
public abstract class ObservableCase<In, Out> {

    protected abstract Observable<Out> buildTask(In data);

    public Observable<Out> sync(In data) {
        return buildTask(data);
    }

    public Observable<Out> async(In data) {
        return buildTask(data)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
