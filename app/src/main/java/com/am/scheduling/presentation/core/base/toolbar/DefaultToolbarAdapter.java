package com.am.scheduling.presentation.core.base.toolbar;

import android.content.res.Resources;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Alex Michenko
 * on 21.02.2018.
 */

public class DefaultToolbarAdapter extends ToolbarAdapter {

    private Toolbar toolbar;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    public DefaultToolbarAdapter(Toolbar toolbar, CollapsingToolbarLayout collapsingToolbarLayout) {
        this.toolbar = toolbar;
        mCollapsingToolbarLayout = collapsingToolbarLayout;
    }

    @Override
    public Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    public void showToolbar() {
        mCollapsingToolbarLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideToolbar() {
        mCollapsingToolbarLayout.setVisibility(View.GONE);
    }

    @Override
    public void useElevation(boolean isEnable) {
        toolbar.setElevation(isEnable ? Resources.getSystem().getDisplayMetrics().density * 4 : 0);
    }

    @Override
    public void setContentView(ToolbarView contentView) {
        if (getCurrentContentView() != null) {
            getCurrentContentView().onDestroyView();
        }
        removeAllView(toolbar);
        contentView.onCreateView(LayoutInflater.from(toolbar.getContext()), mCollapsingToolbarLayout, mCollapsingToolbarLayout);
        setCurrentContentView(contentView);
    }
}
