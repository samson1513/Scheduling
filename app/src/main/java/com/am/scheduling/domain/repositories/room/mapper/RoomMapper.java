package com.am.scheduling.domain.repositories.room.mapper;

import com.am.scheduling.data.database.models.Room;
import com.am.scheduling.presentation.screens.main.managment.room.adapter.RoomDH;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class RoomMapper {

    @Inject
    public RoomMapper() {
    }

    public RoomDH convert(Room room) {
        return new RoomDH(room);
    }
}
