package com.am.scheduling.presentation.abc.core.navigator;

import android.content.Intent;
import android.view.View;

import com.am.scheduling.presentation.abc.core.base.BaseFragment;


/**
 * Created by Alex Michenko
 * on 30.01.2018.
 */

public interface Nav {

    void switchFragment(final BaseFragment _fragment);

    void switchFragment(final BaseFragment _fragment, View... sharedElements);

    void switchFragment(final BaseFragment _fragment, boolean _addToBackStack);

    void switchFragment(final BaseFragment _fragment, boolean _addToBackStack, View... sharedElements);

    void startActivity(final Intent launchIntent);

    void startActivity(final Intent launchIntent, final boolean finishCurrent);

    void startActivityForResult(final Intent launchIntent, final int requestCode);

    BaseFragment getCurrentFragment();

    int getCountFragmentsInBackStack();

    boolean handleBack();
}
