package com.am.scheduling.domain.base.observer;


import android.support.annotation.NonNull;

import com.am.scheduling.domain.base.ErrorObserver;

import io.reactivex.observers.DisposableSingleObserver;

public abstract class DefaultObserver<T> extends DisposableSingleObserver<T> implements ErrorObserver {

    @Override
    public void onError(@NonNull Throwable e) {
        error(e);
    }
}
