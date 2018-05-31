package com.am.scheduling.presentation.abc.core.base;

import android.support.annotation.CallSuper;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Roman Saldan on 4/5/2018.
 */
public abstract class BasePresenterImpl<V extends BaseView> implements BasePresenter {

    protected V view;
    protected CompositeDisposable compositeDisposable;

    public BasePresenterImpl(V view) {
        this.view = view;
        compositeDisposable = new CompositeDisposable();
    }

    @CallSuper
    @Override
    public void unsubscribe() {
        compositeDisposable.clear();
    }

    protected void addDisposable(final Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    protected V getView() {
        return view;
    }
}
