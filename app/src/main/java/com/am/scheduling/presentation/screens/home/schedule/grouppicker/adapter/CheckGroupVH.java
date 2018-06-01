package com.am.scheduling.presentation.screens.home.schedule.grouppicker.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.list.adapter.BaseVH;

import butterknife.BindView;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CheckGroupVH extends BaseVH<CheckGroupDH> {

    @BindView(R.id.text_name_ig)
    TextView mTextNameIg;
    @BindView(R.id.text_size_ig)
    TextView mTextSizeIg;
    @BindView(R.id.cb_check)
    CheckBox mCbCheck;

    public CheckGroupVH(View view) {
        super(view);
    }

    @Override
    public void bindData(CheckGroupDH data) {
        mCbCheck.setChecked(data.checked);
        mTextNameIg.setText(data.group.name);
        mTextSizeIg.setText(String.valueOf(data.group.size));
    }
}
