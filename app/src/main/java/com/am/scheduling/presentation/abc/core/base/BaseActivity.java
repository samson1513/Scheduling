package com.am.scheduling.presentation.abc.core.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.view.inputmethod.InputMethodManager;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Roman Saldan on 4/4/2018.
 */
public abstract class BaseActivity<P extends BasePresenter> extends DaggerAppCompatActivity implements BaseView {

    @Inject
    protected P presenter;
    private Unbinder mUnbinder;

    @LayoutRes
    protected abstract int getLayoutResource();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        setContentView(getLayoutResource());
        mUnbinder = ButterKnife.bind(this);
        initUtils();
        initUI();
    }

    @Override
    protected void onStop() {
        super.onStop();
        hideKeyboard();
    }

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) mUnbinder.unbind();
        if (presenter != null) presenter.unsubscribe();
        super.onDestroy();
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (getCurrentFocus() != null && inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
        }
    }

    @CallSuper
    protected void initUtils() {

    }

    protected void initData() {
        //init stuff that doesn't require UI
    }

    protected abstract void initUI(); //init UI stuff

    protected P getPresenter() {
        return presenter;
    }
}
