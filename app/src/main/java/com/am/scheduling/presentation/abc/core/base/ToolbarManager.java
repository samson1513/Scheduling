package com.am.scheduling.presentation.abc.core.base;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public class ToolbarManager {

    private ActionBar actionBar;

    @Inject
    public ToolbarManager() {
    }

    public void bind(ActionBar actionBar) {
        if (actionBar != null) {
            this.actionBar = actionBar;
            this.actionBar.setTitle(null);
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

    public void setTitle(@StringRes int resId) {
        if (actionBar != null) {
            actionBar.setTitle(resId);
        }
    }

    public void setTitle(String title) {
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }


    public void setSubtitle(int resId) {
        if (actionBar != null) {
            actionBar.setSubtitle(resId);
        }
    }

    public void setSubtitle(String title) {
        if (actionBar != null) {
            actionBar.setSubtitle(title);
        }
    }
}
