package com.am.scheduling.presentation.screens.home.management.timeslot.create.adapter.day;

import android.view.View;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.list.adapter.BaseVH;
import com.am.scheduling.presentation.abc.core.list.adapter.DelegateVH;
import com.am.scheduling.presentation.abc.core.list.adapter.SimpleAdapter;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class DaysAdapter extends SimpleAdapter<DayDH> {


    @Inject
    public DaysAdapter() {
    }

    @Override
    protected void initViewTypes(ViewTypeBuilder builder) {
        builder.addViewType(0, R.layout.item_day, new DelegateVH<DayDH>() {
            @Override
            public BaseVH<DayDH> createVH(View view) {
                return new DayVH(view);
            }
        });
    }
}
