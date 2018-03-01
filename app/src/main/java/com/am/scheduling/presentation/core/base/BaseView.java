package com.am.scheduling.presentation.core.base;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public interface BaseView<P extends BasePresenter> {
    P getPresenter();
    void showMessage(String message);
}
