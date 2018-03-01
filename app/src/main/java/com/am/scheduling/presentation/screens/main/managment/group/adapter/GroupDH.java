package com.am.scheduling.presentation.screens.main.managment.group.adapter;

import com.am.scheduling.data.database.models.Group;
import com.am.scheduling.data.database.models.Room;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class GroupDH implements MultiItemEntity {

    public Group group;

    public GroupDH(Group group) {
        this.group = group;
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
