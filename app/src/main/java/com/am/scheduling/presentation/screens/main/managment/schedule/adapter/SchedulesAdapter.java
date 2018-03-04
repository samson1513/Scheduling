package com.am.scheduling.presentation.screens.main.managment.schedule.adapter;

import android.view.View;

import com.am.scheduling.R;
import com.am.scheduling.presentation.core.list.adapter.BaseVH;
import com.am.scheduling.presentation.core.list.adapter.DelegateVH;
import com.am.scheduling.presentation.core.list.adapter.SimpleAdapter;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class SchedulesAdapter extends SimpleAdapter<ScheduleDH> {


    @Inject
    public SchedulesAdapter() {
    }

    @Override
    protected void initViewTypes() {
        addViewType(0, R.layout.item_schedule, new DelegateVH<ScheduleDH>() {
            @Override
            public BaseVH<ScheduleDH> createVH(View view) {
                return new ScheduleVH(view);
            }
        });
    }
}
