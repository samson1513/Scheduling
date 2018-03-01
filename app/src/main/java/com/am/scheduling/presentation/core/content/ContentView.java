package com.am.scheduling.presentation.core.content;


import com.am.scheduling.presentation.core.base.BaseView;
import com.am.scheduling.presentation.core.content.placeholder.Holder;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public interface ContentView<P extends ContentPresenter> extends BaseView<P> {

    void showProgress();
    void hideProgress();
    void showPlaceholder(@Holder.Type int type);
}
