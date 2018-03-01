package com.am.scheduling.presentation.utils.ui;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.v7.widget.SearchView;
import android.view.View;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by Alex Michenko
 * on 12.01.2018.
 */

public class RxView {

    public static final long CLICK_DELAY = 750;

    @CheckResult
    @NonNull
    public static Observable<Object> clicks(@NonNull View view) {
        return new ViewClickObservable(view);
    }

    @CheckResult
    @NonNull
    public static Observable<Object> safeClicks(@NonNull View view) {
        return clicks(view)
                .throttleFirst(CLICK_DELAY, TimeUnit.MILLISECONDS);
    }

    @CheckResult
    @NonNull
    public static Observable<String> queryTextChanged(@NonNull SearchView searchView) {
        return new QuerySearchObservable(searchView);
    }

    @CheckResult
    @NonNull
    public static Observable<String> queryTextChangedDebounce(@NonNull SearchView searchView, long timeout, TimeUnit unit) {
        return queryTextChanged(searchView)
                .debounce(timeout, unit)
                .observeOn(AndroidSchedulers.mainThread());
    }
}
