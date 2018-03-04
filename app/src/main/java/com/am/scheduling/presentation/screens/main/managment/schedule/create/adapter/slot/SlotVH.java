package com.am.scheduling.presentation.screens.main.managment.schedule.create.adapter.slot;

import android.view.View;
import android.widget.TextView;

import com.am.scheduling.R;
import com.am.scheduling.presentation.core.list.adapter.BaseVH;
import com.am.scheduling.presentation.core.list.adapter.ChildClickable;

import butterknife.BindView;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class SlotVH extends BaseVH<SlotDH> implements ChildClickable {

    @BindView(R.id.text_start_time_is)
    TextView mTextStartTimeIs;
    @BindView(R.id.text_end_time_is)
    TextView mTextEndTimeIs;

    public SlotVH(View view) {
        super(view);
    }

    @Override
    public void bindData(SlotDH data) {
        mTextStartTimeIs.setText(data.getStartTimeFormatted());
        mTextEndTimeIs.setText(data.getEndTimeFormatted());
    }

    @Override
    public void setOnChildClickListener() {
        addOnClickListener(R.id.text_start_time_is);
        addOnClickListener(R.id.text_end_time_is);
    }
}
