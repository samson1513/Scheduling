package com.am.scheduling.presentation.screens.home.root.timeslot.list.adapter;

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

public class TimeslotAdapter extends SimpleAdapter<TimeslotDH> {

    @Inject
    public TimeslotAdapter() {
    }

    @Override
    protected void initViewTypes(ViewTypeBuilder builder) {
        builder.addViewType(0, R.layout.item_schedule, new DelegateVH<TimeslotDH>() {
            @Override
            public BaseVH<TimeslotDH> createVH(View view) {
                return new TimeslotVH(view);
            }
        });
    }
}
