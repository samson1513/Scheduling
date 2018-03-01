package com.am.scheduling.presentation.screens.main.managment.group.adapter;

import android.view.View;
import android.widget.TextView;

import com.am.scheduling.R;
import com.am.scheduling.presentation.core.list.adapter.BaseVH;

import butterknife.BindView;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class GroupVH extends BaseVH<GroupDH> {

    @BindView(R.id.text_name_ig)
    TextView mTextNameIg;
    @BindView(R.id.text_size_ig)
    TextView mTextSizeIg;

    public GroupVH(View view) {
        super(view);
    }

    @Override
    public void bindData(GroupDH data) {
        mTextNameIg.setText(data.group.getName());
        mTextSizeIg.setText(String.valueOf(data.group.getSize()));
    }
}
