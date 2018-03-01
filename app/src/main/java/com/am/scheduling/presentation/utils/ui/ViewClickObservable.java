package com.am.scheduling.presentation.utils.ui;

import android.view.View;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/**
 * Created by Alex Michenko
 * on 12.01.2018.
 */

public class ViewClickObservable extends Observable<Object> {

    private final View view;

    ViewClickObservable(View view) {
        this.view = view;
    }

    @Override
    protected void subscribeActual(Observer<? super Object> observer) {
        Listener listener = new Listener(view, observer);
        observer.onSubscribe(listener);
        view.setOnClickListener(listener);
    }

    static final class Listener extends MainThreadDisposable implements View.OnClickListener {
        private final View view;
        private final Observer<? super Object> observer;

        Listener(View view, Observer<? super Object> observer) {
            this.view = view;
            this.observer = observer;
        }

        @Override
        public void onClick(View v) {
            if (!isDisposed()) {
                observer.onNext(view);
            }
        }

        @Override
        protected void onDispose() {
            view.setOnClickListener(null);
        }
    }
}
