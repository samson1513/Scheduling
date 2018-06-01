package com.am.scheduling.presentation.screens.home.schedule.grouppicker.adapter;

import com.am.scheduling.data.database.models.Group;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CheckGroupDH implements MultiItemEntity {

    public Group group;
    public boolean checked;

    public CheckGroupDH(Group group) {
        this.group = group;
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
