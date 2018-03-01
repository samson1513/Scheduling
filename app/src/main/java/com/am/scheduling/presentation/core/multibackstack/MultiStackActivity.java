package com.am.scheduling.presentation.core.multibackstack;


import com.am.scheduling.presentation.core.base.BaseFragment;
import com.am.scheduling.presentation.core.base.BasePresenter;
import com.am.scheduling.presentation.core.content.StackActivity;
import com.am.scheduling.presentation.core.multibackstack.navigation.MultiBackStackNavigator;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public abstract class MultiStackActivity<P extends BasePresenter> extends StackActivity<P> {

    @Inject
    protected MultiBackStackNavigator mNavigator;

    protected abstract BaseFragment getRootFragmentByHostId(int hostId);

    @Override
    public MultiBackStackNavigator getNavigator() {
        return mNavigator;
    }

    public void selectTab(int hostId) {
        if (getNavigator().getCountFragmentsInBackStack(hostId) == 0) {
            getNavigator().showFragment(getRootFragmentByHostId(hostId), hostId);
        } else {
            getNavigator().showFragment(this, hostId);
        }
    }

    public void reselectTab(int hostId) {
        getNavigator().showFragmentWithClear(getRootFragmentByHostId(hostId), hostId);
    }
}
