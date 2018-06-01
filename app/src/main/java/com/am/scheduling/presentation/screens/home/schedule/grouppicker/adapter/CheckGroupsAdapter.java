package com.am.scheduling.presentation.screens.home.schedule.grouppicker.adapter;

import android.view.View;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.list.adapter.BaseVH;
import com.am.scheduling.presentation.abc.core.list.adapter.DelegateVH;
import com.am.scheduling.presentation.abc.core.list.adapter.SimpleAdapter;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CheckGroupsAdapter extends SimpleAdapter<CheckGroupDH> {

    @Inject
    public CheckGroupsAdapter() {
    }

    @Override
    protected void initViewTypes(ViewTypeBuilder builder) {
        builder.addViewType(0, R.layout.item_group_check, new DelegateVH<CheckGroupDH>() {
            @Override
            public BaseVH<CheckGroupDH> createVH(View view) {
                return new CheckGroupVH(view);
            }
        });
    }
}
