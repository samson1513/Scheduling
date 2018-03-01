package com.am.scheduling.domain.base.single;



import com.am.scheduling.domain.base.ErrorObserver;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;

public abstract class DefaultSingleObserver<T> extends DisposableSingleObserver<T> implements ErrorObserver {

    @Override
    public void onError(@NonNull Throwable e) {
        error(e);
    }
}
