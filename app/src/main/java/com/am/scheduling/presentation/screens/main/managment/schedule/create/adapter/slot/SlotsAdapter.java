package com.am.scheduling.presentation.screens.main.managment.schedule.create.adapter.slot;

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

public class SlotsAdapter extends SimpleAdapter<SlotDH> {

    @Inject
    public SlotsAdapter() {
    }

    @Override
    protected void initViewTypes() {
        addViewType(0, R.layout.item_slot, new DelegateVH<SlotDH>() {
            @Override
            public BaseVH<SlotDH> createVH(View view) {
                return new SlotVH(view);
            }
        });
    }
}
