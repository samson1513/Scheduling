package com.am.scheduling.presentation.utils.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/**
 * Created by Alex Michenko
 * on 01.06.2018.
 */
public class TextChangeObservable extends Observable<String> {

    private final EditText view;

    TextChangeObservable(EditText view) {
        this.view = view;
    }

    @Override
    protected void subscribeActual(Observer<? super String> observer) {
        TextChangeListener listener = new TextChangeListener(view, observer);
        observer.onSubscribe(listener);
        view.addTextChangedListener(listener);
    }

    static final class TextChangeListener extends MainThreadDisposable implements TextWatcher {
        private final EditText view;
        private final Observer<? super String> observer;

        TextChangeListener(EditText view, Observer<? super String> observer) {
            this.view = view;
            this.observer = observer;
        }

        @Override
        protected void onDispose() {
            view.removeTextChangedListener(this);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            observer.onNext(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
