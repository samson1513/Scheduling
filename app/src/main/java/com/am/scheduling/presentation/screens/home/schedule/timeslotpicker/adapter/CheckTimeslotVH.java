package com.am.scheduling.presentation.screens.home.schedule.timeslotpicker.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.list.adapter.BaseVH;
import com.am.scheduling.presentation.utils.DateUtil;

import butterknife.BindView;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CheckTimeslotVH extends BaseVH<CheckTimeslotDH> {

    @BindView(R.id.text_days)
    TextView mTextDays;
    @BindView(R.id.text_time)
    TextView mTextTime;
    @BindView(R.id.cb_check)
    CheckBox mCbCheck;

    public CheckTimeslotVH(View view) {
        super(view);
    }

    @Override
    public void bindData(CheckTimeslotDH data) {
        mCbCheck.setChecked(data.checked);
        mTextDays.setText(DateUtil.toString(data.model.startTime, DateUtil.PATTERN_WEEK_DAY_TIME));
        mTextTime.setText(DateUtil.toString(data.model.endTime, DateUtil.PATTERN_TIME));
    }
}
