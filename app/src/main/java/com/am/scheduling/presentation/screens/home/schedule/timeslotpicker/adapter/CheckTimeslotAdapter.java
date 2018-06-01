package com.am.scheduling.presentation.screens.home.schedule.timeslotpicker.adapter;

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

public class CheckTimeslotAdapter extends SimpleAdapter<CheckTimeslotDH> {

    @Inject
    public CheckTimeslotAdapter() {
    }

    @Override
    protected void initViewTypes(ViewTypeBuilder builder) {
        builder.addViewType(0, R.layout.item_timeslot_check, new DelegateVH<CheckTimeslotDH>() {
            @Override
            public BaseVH<CheckTimeslotDH> createVH(View view) {
                return new CheckTimeslotVH(view);
            }
        });
    }
}
