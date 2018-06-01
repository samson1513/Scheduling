package com.am.scheduling.presentation.utils.ui;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.TimeUnit;

import javax.annotation.Nonnull;

import io.reactivex.Observable;

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
    @Nonnull
    public static Observable<String> textChanged(@Nonnull EditText editText) {
        return new TextChangeObservable(editText);
    }
}
