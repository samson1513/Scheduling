package com.am.scheduling.presentation.screens.home.schedule.timeslotpicker.adapter;

import com.am.scheduling.data.database.models.Timeslot;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CheckTimeslotDH implements MultiItemEntity {

    public Timeslot model;
    public boolean checked;

    public CheckTimeslotDH(Timeslot model) {
        this.model = model;
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
