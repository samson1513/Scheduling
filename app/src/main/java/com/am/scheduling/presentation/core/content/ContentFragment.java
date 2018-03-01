package com.am.scheduling.presentation.core.content;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.am.scheduling.R;
import com.am.scheduling.presentation.core.base.BaseFragment;
import com.am.scheduling.presentation.core.content.placeholder.Holder;
import com.am.scheduling.presentation.core.content.placeholder.HolderManager;
import com.am.scheduling.presentation.core.content.placeholder.OneButtonHolder;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public abstract class ContentFragment<P extends ContentPresenter> extends BaseFragment<P> implements ContentView<P> {

    @Inject
    protected HolderManager holderManager;

    @Override
    @CallSuper
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupHolderManager(holderManager);
    }

    protected void setupHolderManager(HolderManager holderManager) {
        if (getView() != null) {
            holderManager.putHolder(Holder.PROGRESS, new Holder(R.layout.holder_progress, getView()));

            holderManager.putHolder(Holder.UNKNOWN, new OneButtonHolder.Builder(getView())
                    .setText(R.string.err_something_went_wrong)
                    .setActionButton(R.string.action_retry, v -> getPresenter().loadData())
                    .build()
            );
        }
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
        hideProgress();
        holderManager.show(type);
    }
}
