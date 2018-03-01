package com.am.scheduling.domain.repositories.group.mapper;

import com.am.scheduling.data.database.models.Group;
import com.am.scheduling.data.database.models.Room;
import com.am.scheduling.presentation.screens.main.managment.group.adapter.GroupDH;
import com.am.scheduling.presentation.screens.main.managment.room.adapter.RoomDH;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class GroupMapper {

    @Inject
    public GroupMapper() {
    }

    public GroupDH convert(Group group) {
        return new GroupDH(group);
    }
}
