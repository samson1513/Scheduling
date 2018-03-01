package com.am.scheduling.presentation.screens.main.managment.group.adapter;

import android.view.View;
import android.widget.TextView;

import com.am.scheduling.R;
import com.am.scheduling.presentation.core.list.adapter.BaseVH;
import com.am.scheduling.presentation.core.list.adapter.DelegateVH;
import com.am.scheduling.presentation.core.list.adapter.SimpleAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class GroupsAdapter extends SimpleAdapter<GroupDH> {

    @Inject
    public GroupsAdapter() {
    }

    @Override
    protected void initViewTypes() {
        addViewType(0, R.layout.item_group, new DelegateVH<GroupDH>() {
            @Override
            public BaseVH<GroupDH> createVH(View view) {
                return new GroupVH(view);
            }
        });
    }
}
