package com.am.scheduling.presentation.screens.main.managment.room.adapter;

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

public class RoomsAdapter extends SimpleAdapter<RoomDH> {

    @Inject
    public RoomsAdapter() {
    }

    @Override
    protected void initViewTypes() {
        addViewType(0, R.layout.item_room, new DelegateVH<RoomDH>() {
            @Override
            public BaseVH<RoomDH> createVH(View view) {
                return new RoomVH(view);
            }
        });
    }
}
