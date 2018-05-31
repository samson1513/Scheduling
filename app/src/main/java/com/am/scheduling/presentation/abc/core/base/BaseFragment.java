package com.am.scheduling.presentation.abc.core.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.am.scheduling.presentation.abc.core.content.ContentActivity;
import com.am.scheduling.presentation.abc.core.navigator.Nav;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

/**
 * Created by Roman Saldan on 4/4/2018.
 */
public abstract class BaseFragment<P extends BasePresenter> extends DaggerFragment {

    protected ContentActivity activity;
    protected Unbinder mUnbinder;

    @Inject
    protected P presenter;

    @LayoutRes
    protected abstract int getLayoutResource();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activity = (ContentActivity) context;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("BaseFragment should be in ContentActivity");
        }
        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResource(), container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hideKeyboard();
        initUtils();
        initUI();
    }

    @Override
    public void onStop() {
        super.onStop();
        hideKeyboard();
    }

    @Override
    public void onDestroyView() {
        presenter.unsubscribe();
        mUnbinder.unbind();
        super.onDestroyView();
    }

    protected Nav getNavigator() {
        return activity.getNavigator();
    }

    protected ToolbarManager getToolbarManager() {
        return activity.getToolbarManager();
    }

    protected void hideKeyboard() {
        activity.hideKeyboard();
    }

    protected P getPresenter() {
        return presenter;
    }

    public abstract void initUI();

    @CallSuper
    protected void initUtils() {

    }

}
