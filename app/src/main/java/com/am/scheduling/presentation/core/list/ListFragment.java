package com.am.scheduling.presentation.core.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.am.scheduling.R;
import com.am.scheduling.presentation.core.content.ContentFragment;
import com.am.scheduling.presentation.core.content.placeholder.Holder;
import com.am.scheduling.presentation.core.content.placeholder.HolderManager;
import com.am.scheduling.presentation.core.content.placeholder.SimpleHolder;
import com.am.scheduling.presentation.core.list.adapter.SimpleAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public abstract class ListFragment<DH extends MultiItemEntity, P extends ListPresenter> extends ContentFragment<P> implements ListView<DH, P> {

    @Nullable
    @BindView(R.id.rv_bfl_list)
    protected RecyclerView rvBflList;

    protected abstract SimpleAdapter<DH> getAdapter();

    @Override
    protected int getLayoutResource() {
        return R.layout.base_fragment_list;
    }

    @Override
    protected void setupHolderManager(HolderManager holderManager) {
        super.setupHolderManager(holderManager);
        holderManager.putHolder(Holder.EMPTY, new SimpleHolder.Builder(getRecyclerView())
                .setText(R.string.err_no_data)
                .build()
        );
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getRecyclerView().setAdapter(getAdapter());
        getRecyclerView().setLayoutManager(getLayoutManager());
    }

    @Override
    public void setItems(List<DH> items) {
        getAdapter().setNewData(items);
    }

    @Override
    public void addItems(List<DH> items) {
        getAdapter().addData(items);
    }

    @Override
    public void updateItem(DH item, int position) {
        getAdapter().setData(position, item);
    }

    @Override
    public void addItem(DH item) {
        getAdapter().addData(item);
    }

    @Override
    public void addItem(DH item, int position) {
        getAdapter().addData(position, item);
    }

    @Override
    public void removeItem(int position) {
        getAdapter().remove(position);
    }

    @Override
    public void showLoadMoreError() {
        getAdapter().loadMoreFail();
    }

    @Override
    public void disablePagination() {
        getAdapter().setEnableLoadMore(false);
        getAdapter().loadMoreEnd(true);
    }

    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    protected RecyclerView getRecyclerView() {
        return rvBflList;
    }
}
