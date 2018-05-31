package com.am.scheduling.presentation.core.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.am.scheduling.presentation.abc.core.base.ToolbarManager;
import com.am.scheduling.presentation.core.content.StackActivity;
import com.am.scheduling.presentation.core.content.navigation.Navigator;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public abstract class BaseFragment<P extends BasePresenter> extends DaggerFragment implements BaseView<P>  {


    protected Unbinder mUnbinder;
    protected InputMethodManager inputMethodManager;

    protected Snackbar snackbar;

    @LayoutRes
    protected abstract int getLayoutResource();

    protected abstract void onViewReady(@Nullable Bundle savedInstanceState);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        inputMethodManager = (InputMethodManager) getStackActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        parseArguments(getArguments());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResource(), container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        snackbar = Snackbar.make(view, "", Snackbar.LENGTH_SHORT);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getPresenter().attachView(this);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        onViewReady(savedInstanceState);
    }

    @Override
    public void onStop() {
        hideKeyboard();
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
        if (getPresenter() != null) {
            getPresenter().detachView();
        }
    }

    @Override
    public void showMessage(String message) {
        snackbar.setText(message).show();
    }

    protected void parseArguments(Bundle args) {
    }

    protected Navigator getNavigator() {
        return getStackActivity().getNavigator();
    }

    protected ToolbarManager getToolbarManager() {
        return getStackActivity().getToolbarManager();
    }

    protected void hideKeyboard() {
        if (getView() != null)
            inputMethodManager.hideSoftInputFromWindow(getView().getWindowToken(), 0);
    }

    public StackActivity getStackActivity() {
        return (StackActivity) getActivity();
    }
}
