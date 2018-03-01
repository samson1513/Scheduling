package com.am.scheduling.presentation.core.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public class BasePresenterImpl<V extends BaseView> implements BasePresenter<V> {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private WeakReference<V> baseView;

    @Override
    public void attachView(V view) {
        baseView = new WeakReference<>(view);
    }

    protected boolean isViewAttached() {
        return baseView != null && baseView.get() != null;
    }

    public V getView() {
        return baseView.get();
    }

    protected void addDisposable(final Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    @Override
    public void detachView() {
        compositeDisposable.clear();
        if (baseView != null)
            baseView.clear();
    }
}
