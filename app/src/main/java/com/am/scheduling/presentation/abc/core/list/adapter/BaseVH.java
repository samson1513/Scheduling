package com.am.scheduling.presentation.abc.core.list.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import butterknife.ButterKnife;

/**
 * Created by Roman Saldan on 4/6/2018.
 */
public abstract class BaseVH<DH extends MultiItemEntity> extends BaseViewHolder {

    public BaseVH(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public abstract void bindData(DH data);
}
