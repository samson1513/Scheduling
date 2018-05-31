package com.am.scheduling.presentation.abc.core.content;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.base.BaseFragment;
import com.am.scheduling.presentation.abc.core.base.BasePresenter;
import com.am.scheduling.presentation.abc.core.placeholder.Holder;
import com.am.scheduling.presentation.abc.core.placeholder.HolderManager;
import com.am.scheduling.presentation.abc.core.placeholder.OneButtonHolder;
import com.am.scheduling.presentation.abc.core.placeholder.ProgressHolder;

import javax.inject.Inject;

/**
 * Created by Roman Saldan on 4/5/2018.
 */
public abstract class ContentFragment<P extends BasePresenter> extends BaseFragment<P> implements ContentView {

    @Inject
    protected HolderManager holderManager;

    private Snackbar snackbar;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setupHolderManager(holderManager);
        snackbar = Snackbar.make(view, null, Snackbar.LENGTH_SHORT);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void showProgress() {
        holderManager.show(Holder.PROGRESS);
    }

    @Override
    public void hideProgress() {
        holderManager.hide();
    }

    @Override
    public void showPlaceholder(int type) {
        holderManager.show(type);
    }

    protected void setupHolderManager(HolderManager holderManager) {
        holderManager.putHolder(Holder.PROGRESS, new ProgressHolder(getView()));

        holderManager.putHolder(Holder.UNKNOWN, new OneButtonHolder.Builder(getView())
                .setText(R.string.err_something_went_wrong)
                .setActionButton(R.string.action_retry, v -> getPresenter().subscribe())
                .build()
        );
    }

    @Override
    public void onDestroyView() {
        holderManager.clear();
        super.onDestroyView();
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_SHORT).show();
    }
}
