package com.am.scheduling.domain.base.input;


import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alex Michenko
 * on 26.04.2018.
 */
public abstract class SingleCase<In, Out> {

    protected abstract Single<Out> buildTask(In data);

    public Single<Out> sync(In data) {
        return buildTask(data);
    }

    public Single<Out> async(In data) {
        return buildTask(data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
