package com.am.scheduling.presentation.core.content.navigation;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


import com.am.scheduling.presentation.core.base.BaseActivity;
import com.am.scheduling.presentation.core.base.BaseFragment;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public class NavigatorImpl implements Navigator {

    protected FragmentManager fragmentManager;
    protected int containerId;

    @Inject
    public NavigatorImpl() {
    }

    @Override
    public void bind(FragmentManager fragmentManager, @IdRes int containerId) {
        this.fragmentManager = fragmentManager;
        this.containerId = containerId;
    }

    @Override
    public void unbind() {
        fragmentManager = null;
    }

    @Override
    public void clearBackStack() {
        if (fragmentManager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry entry = fragmentManager.getBackStackEntryAt(0);
            fragmentManager.popBackStackImmediate(entry.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    @Override
    public void showFragment(BaseFragment fragment) {
        fragmentManager.beginTransaction()
                .replace(containerId, fragment, fragment.getClass().getName())
                .addToBackStack(fragment.getClass().getName())
                .commit();
    }

    @Override
    public void startActivity(BaseActivity activity, Intent launchIntent) {
        startActivity(activity, launchIntent, false);
    }

    @Override
    public void startActivity(BaseActivity activity, Intent launchIntent, boolean finishCurrent) {
        if (finishCurrent) {
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        activity.startActivity(launchIntent);
    }

    @Override
    public void startActivity(Fragment fragment, Intent launchIntent) {
        startActivity(fragment, launchIntent, false);
    }

    @Override
    public void startActivity(Fragment fragment, Intent launchIntent, boolean finishCurrent) {
        if (finishCurrent) {
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        fragment.startActivity(launchIntent);
    }

    @Override
    public void startActivityForResult(BaseActivity activity, Intent launchIntent, int requestCode) {
        activity.startActivityForResult(launchIntent, requestCode);
    }

    @Override
    public void startActivityForResult(Fragment fragment, Intent launchIntent, int requestCode) {
        fragment.startActivityForResult(launchIntent, requestCode);
    }

    @Override
    public BaseFragment getCurrentFragment() {
        return (BaseFragment) fragmentManager.findFragmentById(containerId);
    }

    @Override
    public int getCountFragmentsInBackStack() {
        return fragmentManager.getBackStackEntryCount();
    }

    @Override
    public boolean handleBack(Context context) {
        if (fragmentManager.getBackStackEntryCount() > 1) {
            fragmentManager.popBackStack();
            return true;
        } else {
            return false;
        }
    }
}
