package com.am.scheduling.presentation.core.base.toolbar;

import android.content.res.Resources;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Alex Michenko
 * on 20.02.2018.
 */

public abstract class ToolbarAdapter {

    protected ToolbarView currentContentView;

    public abstract Toolbar getToolbar();
    public abstract void useElevation(boolean isEnable);
    public abstract void setContentView(ToolbarView contentView);
    public abstract void showToolbar();
    public abstract void hideToolbar();

    public ToolbarView getCurrentContentView() {
        return currentContentView;
    }

    public void setCurrentContentView(ToolbarView currentContentView) {
        this.currentContentView = currentContentView;
    }

    public void setTitle(int resId) {
        if (getCurrentContentView() != null) {
            getCurrentContentView().setTitle(resId);
        }
    }

    public void setTitle(String title) {
        if (getCurrentContentView() != null) {
            getCurrentContentView().setTitle(title);
        }
    }

    public void setSubtitle(int resId) {
        if (getCurrentContentView() != null) {
            getCurrentContentView().setSubtitle(resId);
        }
    }

    public void setSubtitle(String title) {
        if (getCurrentContentView() != null) {
            getCurrentContentView().setSubtitle(title);
        }
    }

    protected void removeAllView(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View view = viewGroup.getChildAt(i);
            if (!(view instanceof Toolbar)) {
                viewGroup.removeViewAt(i);
            }
        }
    }
}
