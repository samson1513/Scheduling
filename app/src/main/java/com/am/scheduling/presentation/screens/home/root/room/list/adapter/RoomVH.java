package com.am.scheduling.presentation.screens.home.root.room.list.adapter;

import android.view.View;
import android.widget.TextView;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.list.adapter.BaseVH;

import butterknife.BindView;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class RoomVH extends BaseVH<RoomDH> {

    @BindView(R.id.text_name_ir)
    TextView mTextNameIr;
    @BindView(R.id.text_capacity_ir)
    TextView mTextCapacityIr;

    public RoomVH(View view) {
        super(view);
    }

    @Override
    public void bindData(RoomDH data) {
        mTextNameIr.setText(data.room.name);
        mTextCapacityIr.setText(String.valueOf(data.room.capacity));
    }
}
