package com.am.scheduling.presentation.core.multibackstack.navigation;

import android.content.Context;
import android.os.Bundle;

import com.am.scheduling.presentation.core.base.BaseFragment;
import com.am.scheduling.presentation.core.content.navigation.Navigator;
import com.am.scheduling.presentation.core.multibackstack.MultiStackActivity;


/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public interface MultiBackStackNavigator extends Navigator {

    int NO_HOST_ID = -1;

    void showFragment(Context context, final int hostId);

    void showFragment(final BaseFragment fragment, final int hostId);

    void showFragmentWithClear(final BaseFragment fragment, final int hostId);

    int getCountFragmentsInBackStack(final int hostId);

    void restoreState(final Bundle savedState, final MultiStackActivity activity);

    void saveState(final Bundle outState);
}
