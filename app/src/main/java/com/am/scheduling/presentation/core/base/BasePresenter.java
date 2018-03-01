package com.am.scheduling.presentation.core.base;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);
    void detachView();
    V getView();
}
