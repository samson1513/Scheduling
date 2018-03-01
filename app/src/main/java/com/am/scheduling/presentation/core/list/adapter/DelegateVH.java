package com.am.scheduling.presentation.core.list.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public abstract class DelegateVH<DH extends MultiItemEntity> {
    public abstract BaseVH<DH> createVH(View view);
    public void bindDH(BaseViewHolder vh, MultiItemEntity data){
        ((BaseVH<DH>)vh).bindData((DH)data);
    }
}
