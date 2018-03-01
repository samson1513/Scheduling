package com.am.scheduling.presentation.core.content;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.am.scheduling.R;
import com.am.scheduling.presentation.core.base.BaseActivity;
import com.am.scheduling.presentation.core.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 08.02.2018.
 */

public abstract class StackActivity<P extends BasePresenter> extends BaseActivity<P> {


    private boolean mBackPressedOnce = false;

    @IdRes
    public abstract int getFragmentContainer();

    @Override
    protected void setupManagers() {
        super.setupManagers();
        getNavigator().bind(getSupportFragmentManager(), getFragmentContainer());
        getSupportFragmentManager().addOnBackStackChangedListener(this::onBackStackChanged);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment fragment = getNavigator().getCurrentFragment();
        return fragment != null && fragment.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (!getNavigator().handleBack(this)) {
            if (needDoubleClickForExit()) {
                if (mBackPressedOnce) {
                    finish();
                } else {
                    mBackPressedOnce = true;
                    showMessage(getString(R.string.err_back_to_exit));
                    new Handler().postDelayed(() -> mBackPressedOnce = false, 2000);
                }
            } else {
                finish();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragment = getNavigator().getCurrentFragment();
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onDestroy() {
        getSupportFragmentManager().removeOnBackStackChangedListener(this::onBackStackChanged);
        getNavigator().unbind();
        super.onDestroy();
    }


    protected boolean needDoubleClickForExit() {
        return true;
    }

    protected void onBackStackChanged() {
        if (getNavigator().getCountFragmentsInBackStack() > 1) {
            getToolbarManager().showHomeButton();
        } else {
            getToolbarManager().hideHomeButton();
        }
    }
}
