package com.am.scheduling.presentation.core.content.navigation;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.am.scheduling.presentation.core.base.BaseActivity;
import com.am.scheduling.presentation.core.base.BaseFragment;


/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public interface Navigator {

    void bind(final FragmentManager fragmentManager, @IdRes final int containerId);

    void unbind();

    void clearBackStack();

    void showFragment(final BaseFragment _fragment);

    void startActivity(final BaseActivity activity, final Intent launchIntent);

    void startActivity(final BaseActivity activity, final Intent launchIntent, final boolean finishCurrent);

    void startActivity(final Fragment fragment, final Intent launchIntent);

    void startActivity(final Fragment fragment, final Intent launchIntent, final boolean finishCurrent);

    void startActivityForResult(final BaseActivity activity, final Intent launchIntent, final int requestCode);

    void startActivityForResult(final Fragment fragment, final Intent launchIntent, final int requestCode);

    BaseFragment getCurrentFragment();

    int getCountFragmentsInBackStack();

    boolean handleBack(Context context);
}
