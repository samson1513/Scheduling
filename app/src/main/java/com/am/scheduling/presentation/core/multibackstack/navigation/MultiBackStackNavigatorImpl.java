package com.am.scheduling.presentation.core.multibackstack.navigation;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;


import com.am.scheduling.presentation.core.base.BaseFragment;
import com.am.scheduling.presentation.core.content.navigation.NavigatorImpl;
import com.am.scheduling.presentation.core.multibackstack.MultiStackActivity;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public class MultiBackStackNavigatorImpl extends NavigatorImpl implements MultiBackStackNavigator {

    private static final String STATE_BACK_STACK_MANAGER = "back_stack_manager";
    private static final String STATE_HOST_ID = "host_id";

    private BackStackManager mBackStackManager;
    private int mCurrentHostId = NO_HOST_ID;

    @Inject
    public MultiBackStackNavigatorImpl() {
        mBackStackManager = new BackStackManager();
    }

    @Override
    public void showFragment(Context context, int hostId) {
        mCurrentHostId = hostId;
        Fragment frag = peakFragmentFromBackStack(context, hostId);
        if (frag != null) {
            replaceFragment(frag);
        }
    }

    @Override
    public void showFragment(BaseFragment fragment) {
        showFragment(fragment, mCurrentHostId);
    }

    @Override
    public void showFragment(final BaseFragment fragment, final int hostId) {
        mCurrentHostId = hostId;
        replaceFragment(fragment);
        pushFragmentToBackStack(fragment, mCurrentHostId);
    }

    @Override
    public void showFragmentWithClear(BaseFragment fragment, int hostId) {
        mBackStackManager.clear(hostId);
        showFragment(fragment, hostId);
    }

    @Override
    public int getCountFragmentsInBackStack() {
        return getCountFragmentsInBackStack(mCurrentHostId);
    }

    @Override
    public int getCountFragmentsInBackStack(int hostId) {
        return mBackStackManager.backStackSize(hostId);
    }

    @Override
    public boolean handleBack(Context context) {
        if (mBackStackManager.backStackSize(mCurrentHostId) == 1) {
            return false;
        } else {
            Fragment frag = popFragmentFromBackStack(context, mCurrentHostId);
            if (frag == null) {
                return false;
            } else {
                replaceFragment(frag);
                return true;
            }
        }
    }

    @Override
    public void restoreState(final Bundle savedState, final MultiStackActivity activity) {
        mCurrentHostId = savedState.getInt(STATE_HOST_ID);
        mBackStackManager.restoreState(savedState.getParcelable(STATE_BACK_STACK_MANAGER));
        activity.selectTab(mCurrentHostId);
    }

    @Override
    public void saveState(final Bundle outState) {
        outState.putParcelable(STATE_BACK_STACK_MANAGER, mBackStackManager.saveState());
        outState.putInt(STATE_HOST_ID, mCurrentHostId);
    }

    @Override
    public void unbind() {
        super.unbind();
        mBackStackManager = null;
    }

    private void replaceFragment(@NonNull final Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(containerId, fragment)
                .commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
    }

    private void pushFragmentToBackStack(@NonNull final BaseFragment fragment, final int hostId) {
        BackStackEntry entry = BackStackEntry.create(fragmentManager, fragment);
        mBackStackManager.push(hostId, entry);
    }

    @Nullable
    private Fragment popFragmentFromBackStack(final Context context, final int hostId) {
        mBackStackManager.pop(hostId);
        return peakFragmentFromBackStack(context, hostId);
    }

    @Nullable
    private Fragment peakFragmentFromBackStack(final Context context, final int hostId) {
        BackStackEntry entry = mBackStackManager.peek(hostId);
        return entry != null ? entry.toFragment(context) : null;
    }
}
