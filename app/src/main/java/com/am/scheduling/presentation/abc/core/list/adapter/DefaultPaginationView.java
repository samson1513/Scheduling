package com.am.scheduling.presentation.abc.core.list.adapter;

import com.am.scheduling.R;
import com.chad.library.adapter.base.loadmore.LoadMoreView;

/**
 * Created by Roman Saldan on 4/10/2018.
 */
public class DefaultPaginationView extends LoadMoreView {
    @Override
    public int getLayoutId() {
        return R.layout.holder_progress_pagination;
    }

    @Override
    protected int getLoadingViewId() {
        return R.id.iv_hpp_progress;
    }

    @Override
    protected int getLoadFailViewId() {
        return R.id.tv_hpp_retry;
    }

    @Override
    protected int getLoadEndViewId() {
        return 0;
    }
}
