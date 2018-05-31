package com.am.scheduling.presentation.abc.core.list.pager;

import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Alex Michenko
 * on 22.05.2018.
 */

public abstract class PagerVH<DH extends PagerDH> {

    public View itemView;
    public int position;
    public int viewType;

    public PagerVH(View itemView) {
        this.itemView = itemView;
        ButterKnife.bind(this, itemView);
    }

    public abstract void bindData(DH data);
}
