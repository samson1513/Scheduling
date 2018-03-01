package com.am.scheduling.domain.base.completable;



import com.am.scheduling.domain.base.ErrorObserver;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableCompletableObserver;

public abstract class DefaultCompletableObserver<T> extends DisposableCompletableObserver implements ErrorObserver {

    @Override
    public void onError(@NonNull Throwable e) {
        error(e);
    }
}
