package com.am.scheduling.presentation.screens.home.root.group.list.adapter;

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

public class GroupsAdapter extends SimpleAdapter<GroupDH> {

    @Inject
    public GroupsAdapter() {
    }

    @Override
    protected void initViewTypes(ViewTypeBuilder builder) {
        builder.addViewType(0, R.layout.item_group, new DelegateVH<GroupDH>() {
            @Override
            public BaseVH<GroupDH> createVH(View view) {
                return new GroupVH(view);
            }
        });
    }
}
