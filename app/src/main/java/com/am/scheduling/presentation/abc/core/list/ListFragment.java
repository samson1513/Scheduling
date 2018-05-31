package com.am.scheduling.presentation.abc.core.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.content.ContentFragment;
import com.am.scheduling.presentation.abc.core.list.adapter.DefaultPaginationView;
import com.am.scheduling.presentation.abc.core.list.adapter.SimpleAdapter;
import com.am.scheduling.presentation.abc.core.placeholder.Holder;
import com.am.scheduling.presentation.abc.core.placeholder.HolderManager;
import com.am.scheduling.presentation.abc.core.placeholder.SimpleHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.loadmore.LoadMoreView;

import java.util.List;

/**
 * Created by Roman Saldan on 4/6/2018.
 */
public abstract class ListFragment<DH extends MultiItemEntity, P extends ListPresenter> extends ContentFragment<P> implements ListView<DH> {

    public abstract SimpleAdapter<DH> getAdapter();
    public abstract RecyclerView getRecyclerView();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(hasPagination()) {
            getAdapter().setEnableLoadMore(true);
            getAdapter().setPreLoadNumber(getThreshold());
            getAdapter().setLoadMoreView(getLoadMoreView());
        }
    }

    @Override
    protected void setupHolderManager(HolderManager holderManager) {
        super.setupHolderManager(holderManager);
        holderManager.putHolder(Holder.EMPTY, new SimpleHolder.Builder(getRecyclerView())
                .setIcon(R.drawable.ic_no_data)
                .setText(R.string.err_msg_no_data)
                .build()
        );
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(getAdapter().isLoadMoreEnable()) {
            getAdapter().setOnLoadMoreListener(() -> presenter.loadMore(), getRecyclerView());
        }

        getRecyclerView().setAdapter(getAdapter());
        getRecyclerView().setLayoutManager(getLayoutManager());
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    public LoadMoreView getLoadMoreView() {
        return new DefaultPaginationView();
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

    @Override
    public void showProgress() {
        super.showProgress();
        getAdapter().setEnableLoadMore(hasPagination());
    }

    @Override
    public void hideProgress() {
        super.hideProgress();
        getAdapter().loadMoreComplete();
        getAdapter().setEnableLoadMore(hasPagination());
    }

    protected boolean hasPagination() {
        return false;
    }

    protected int getThreshold() {
        return 3;
    }
}
