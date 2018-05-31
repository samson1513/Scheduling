package com.am.scheduling.presentation.abc.core.content;

import android.content.Intent;
import android.support.annotation.CallSuper;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.am.scheduling.presentation.abc.core.base.BaseActivity;
import com.am.scheduling.presentation.abc.core.base.BasePresenter;
import com.am.scheduling.presentation.abc.core.base.ToolbarManager;
import com.am.scheduling.presentation.abc.core.navigator.Nav;

import javax.inject.Inject;

/**
 * Created by Roman Saldan on 4/5/2018.
 */
public abstract class ContentActivity<P extends BasePresenter> extends BaseActivity<P> {

    @Inject
    protected Nav navigator;
    @Inject
    protected ToolbarManager toolbarManager;

    @IdRes
    public abstract int getContainerRes();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragment = getNavigator().getCurrentFragment();
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment fragment = getNavigator().getCurrentFragment();
        if (fragment != null && fragment.onOptionsItemSelected(item)) {
            return true;
        }

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if (!getNavigator().handleBack()) {
            finish();
        }
    }


    public Nav getNavigator() {
        return navigator;
    }

    public ToolbarManager getToolbarManager() {
        return toolbarManager;
    }

    @CallSuper
    @Override
    protected void initUtils() {
        super.initUtils();
        getToolbarManager().bind(getSupportActionBar());
    }
}
