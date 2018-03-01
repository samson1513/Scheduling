package com.am.scheduling.presentation.core.base;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;

import com.am.scheduling.presentation.core.base.toolbar.ToolbarAdapter;
import com.am.scheduling.presentation.core.base.toolbar.ToolbarView;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public class ToolbarManager {

    private ActionBar actionBar;
    private ToolbarAdapter toolbarAdapter;

    @Inject
    public ToolbarManager() {
    }

    public void bind(BaseActivity activity, ToolbarAdapter toolbarAdapter) {
        if (toolbarAdapter != null) {
            activity.setSupportActionBar(toolbarAdapter.getToolbar());
            this.actionBar = activity.getSupportActionBar();
            this.actionBar.setTitle(null);
            this.toolbarAdapter = toolbarAdapter;
        }
    }

    public void setContentView(ToolbarView contentView) {
        if (toolbarAdapter != null) {
            toolbarAdapter.setContentView(contentView);
        }
    }

    public void showHomeButton() {
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    public void setHomeButtonIcon(@DrawableRes int resId) {
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(resId);
        }
    }

    public void hideHomeButton() {
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
        }
    }

    public void showToolbar() {
        if (toolbarAdapter != null) {
            toolbarAdapter.showToolbar();
        }
    }

    public void hideToolbar() {
        if (toolbarAdapter != null) {
            toolbarAdapter.hideToolbar();
        }
    }

    public void useElevation(boolean isEnable) {
        if (toolbarAdapter != null) {
            toolbarAdapter.useElevation(isEnable);
        }
    }

    public void setTitle(@StringRes int resId) {
        if (toolbarAdapter != null) {
            toolbarAdapter.setTitle(resId);
        }
    }

    public void setTitle(String title) {
        if (toolbarAdapter != null) {
            toolbarAdapter.setTitle(title);
        }
    }


    public void setSubtitle(int resId) {
        if (toolbarAdapter != null) {
            toolbarAdapter.setSubtitle(resId);
        }
    }

    public void setSubtitle(String title) {
        if (toolbarAdapter != null) {
            toolbarAdapter.setSubtitle(title);
        }
    }
}
