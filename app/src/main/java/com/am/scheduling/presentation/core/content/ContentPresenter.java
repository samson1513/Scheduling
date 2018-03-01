package com.am.scheduling.presentation.core.content;


import com.am.scheduling.presentation.core.base.BasePresenter;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public interface ContentPresenter<V extends ContentView> extends BasePresenter<V> {

    void loadData();
}
