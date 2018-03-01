package com.am.scheduling.presentation.core.base.toolbar;

import android.support.annotation.StringRes;
import android.support.design.widget.AppBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Alex Michenko
 * on 20.02.2018.
 */

public interface ToolbarView {
    void onCreateView(LayoutInflater inflater, ViewGroup parent, ViewGroup container);
    void setTitle(@StringRes int resId);
    void setTitle(String title);
    void setSubtitle(int resId);
    void setSubtitle(String subtitle);
    void onDestroyView();
}
