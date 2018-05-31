package com.am.scheduling.presentation.abc.core.list;


import com.am.scheduling.presentation.abc.core.base.BasePresenterImpl;

/**
 * Created by Roman Saldan on 4/6/2018.
 */
public abstract class ListPresenterImpl<V extends ListView> extends BasePresenterImpl<V> implements ListPresenter {

    public ListPresenterImpl(V view) {
        super(view);
    }
}
