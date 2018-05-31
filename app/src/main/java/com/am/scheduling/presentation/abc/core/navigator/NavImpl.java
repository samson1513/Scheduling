package com.am.scheduling.presentation.abc.core.navigator;

import android.content.Intent;
import android.support.transition.ChangeBounds;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.am.scheduling.presentation.abc.core.base.BaseFragment;
import com.am.scheduling.presentation.abc.core.content.ContentActivity;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 30.01.2018.
 */

public class NavImpl implements Nav {


    private ContentActivity activity;

    @Inject
    public NavImpl(ContentActivity activity) {
        this.activity = activity;
    }

    private FragmentManager getFragmentManager() {
        return activity.getSupportFragmentManager();
    }

    private int getContainerId() {
        return activity.getContainerRes();
    }

    @Override
    public void switchFragment(BaseFragment _fragment) {
        switchFragment(_fragment, true);
    }

    @Override
    public void switchFragment(BaseFragment _fragment, View... sharedElements) {
        switchFragment(_fragment, true, sharedElements);
    }

    @Override
    public void switchFragment(BaseFragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(getContainerId(), fragment, fragment.getClass().getName());

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }
        fragmentTransaction.commit();
    }

    @Override
    public void switchFragment(BaseFragment _fragment, boolean _addToBackStack, View... sharedElements) {
        BaseFragment currentFragment = getCurrentFragment();

        currentFragment.setExitTransition(new ChangeBounds());
        currentFragment.setSharedElementReturnTransition(new ChangeBounds());

        _fragment.setSharedElementEnterTransition(new ChangeBounds());
        _fragment.setEnterTransition(new ChangeBounds());

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        for (View v : sharedElements) {
            fragmentTransaction.addSharedElement(v, v.getTransitionName());
        }
        fragmentTransaction.replace(getContainerId(), _fragment, _fragment.getClass().getName());
        if (_addToBackStack) {
            fragmentTransaction.addToBackStack(_fragment.getClass().getName());
        } else {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void startActivity(Intent launchIntent) {
        startActivity(launchIntent, false);
    }

    @Override
    public void startActivity(Intent launchIntent, boolean finishCurrent) {
        if (finishCurrent) {
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        activity.startActivity(launchIntent);
    }

    @Override
    public void startActivityForResult(Intent launchIntent, int requestCode) {
        activity.startActivityForResult(launchIntent, requestCode);
    }

    @Override
    public BaseFragment getCurrentFragment() {
        return (BaseFragment) getFragmentManager().findFragmentById(getContainerId());
    }

    @Override
    public int getCountFragmentsInBackStack() {
        return getFragmentManager().getBackStackEntryCount();
    }

    @Override
    public boolean handleBack() {
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            getFragmentManager().popBackStack();
            return true;
        } else {
            return false;
        }
    }
}
