package com.am.scheduling.presentation.screens.main.managment.room.adapter;

import com.am.scheduling.data.database.models.Room;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class RoomDH implements MultiItemEntity {

    public Room room;

    public RoomDH(Room room) {
        this.room = room;
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
