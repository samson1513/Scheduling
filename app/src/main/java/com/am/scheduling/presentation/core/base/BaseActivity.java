package com.am.scheduling.presentation.core.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.am.scheduling.presentation.core.base.toolbar.ToolbarAdapter;
import com.am.scheduling.presentation.core.content.navigation.Navigator;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public abstract class BaseActivity<P extends BasePresenter> extends DaggerAppCompatActivity
        implements BaseView<P> {

    @Inject
    ToolbarManager mToolbarManager;
    private Unbinder mUnbinder;
    @Inject
    protected Navigator mNavigator;

    @LayoutRes
    protected abstract int getLayoutResource();

    protected abstract ToolbarAdapter getToolbarAdapter();

    protected abstract void onViewReady(Bundle savedInstanceState);

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        parseExtras(getIntent());
        setupManagers();
        getPresenter().attachView(this);
        onViewReady(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) mUnbinder.unbind();
        if (getPresenter() != null) getPresenter().detachView();
        super.onDestroy();
    }

    protected void parseExtras(Intent intent) {
    }

    protected void setupManagers() {
        mUnbinder = ButterKnife.bind(this);
        getToolbarManager().bind(this, getToolbarAdapter());
    }

    public ToolbarManager getToolbarManager() {
        return mToolbarManager;
    }

    protected void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public Navigator getNavigator() {
        return mNavigator;
    }
}
