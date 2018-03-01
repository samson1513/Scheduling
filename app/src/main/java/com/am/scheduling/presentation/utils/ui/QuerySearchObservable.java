package com.am.scheduling.presentation.utils.ui;

import android.support.v7.widget.SearchView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/**
 * Created by Alex Michenko
 * on 31.01.2018.
 */

public class QuerySearchObservable extends Observable<String> {

    private final SearchView view;

    QuerySearchObservable(SearchView view) {
        this.view = view;
    }

    @Override
    protected void subscribeActual(Observer<? super String> observer) {
        QueryListener listener = new QueryListener(view, observer);
        observer.onSubscribe(listener);
        view.setOnQueryTextListener(listener);
    }

    static final class QueryListener extends MainThreadDisposable implements SearchView.OnQueryTextListener {
        private final SearchView view;
        private final Observer<? super String> observer;

        QueryListener(SearchView view, Observer<? super String> observer) {
            this.view = view;
            this.observer = observer;
        }

        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            observer.onNext(newText);
            return false;
        }

        @Override
        protected void onDispose() {
            view.setOnQueryTextListener(null);
        }
    }
}
