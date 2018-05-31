package com.am.scheduling.presentation.screens.home.root.timeslot.list.adapter;

import android.view.View;
import android.widget.TextView;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.list.adapter.BaseVH;
import com.am.scheduling.presentation.utils.DateUtil;

import butterknife.BindView;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class TimeslotVH extends BaseVH<TimeslotDH> {

    @BindView(R.id.text_days)
    TextView mTextDays;
    @BindView(R.id.text_time)
    TextView mTextTime;

    public TimeslotVH(View view) {
        super(view);
    }

    @Override
    public void bindData(TimeslotDH data) {
        mTextDays.setText(DateUtil.toString(data.model.startTime, DateUtil.PATTERN_WEEK_DAY_TIME));
        mTextTime.setText(DateUtil.toString(data.model.endTime, DateUtil.PATTERN_TIME));
    }
}
