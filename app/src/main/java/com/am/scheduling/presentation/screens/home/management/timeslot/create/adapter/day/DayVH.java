package com.am.scheduling.presentation.screens.home.management.timeslot.create.adapter.day;

import android.view.View;
import android.widget.TextView;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.list.adapter.BaseVH;

import butterknife.BindView;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class DayVH extends BaseVH<DayDH> {

    @BindView(R.id.text_day_id)
    TextView mTextDayId;

    public DayVH(View view) {
        super(view);
    }

    @Override
    public void bindData(DayDH data) {
        mTextDayId.setText(data.getDayName());
        mTextDayId.setSelected(data.isSelected());
    }
}
