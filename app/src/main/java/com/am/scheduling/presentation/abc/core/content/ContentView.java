package com.am.scheduling.presentation.abc.core.content;


import com.am.scheduling.presentation.abc.core.base.BaseView;
import com.am.scheduling.presentation.abc.core.placeholder.Holder;

/**
 * Created by Roman Saldan on 4/6/2018.
 */
public interface ContentView extends BaseView {
    void showProgress();
    void hideProgress();
    void showPlaceholder(@Holder.Type int type);

    void showMessage(String message);
}
