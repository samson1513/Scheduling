package com.am.scheduling.presentation.screens.main.managment.schedule.adapter;

import android.view.View;
import android.widget.TextView;

import com.am.scheduling.R;
import com.am.scheduling.presentation.core.list.adapter.BaseVH;

import butterknife.BindView;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class ScheduleVH extends BaseVH<ScheduleDH> {

    @BindView(R.id.text_days)
    TextView mTextDays;
    @BindView(R.id.text_time)
    TextView mTextTime;

    public ScheduleVH(View view) {
        super(view);
    }

    @Override
    public void bindData(ScheduleDH data) {
        mTextDays.setText(data.getDays());
        mTextTime.setText(data.getTime());
    }
}
