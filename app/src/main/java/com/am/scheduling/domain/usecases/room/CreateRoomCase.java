package com.am.scheduling.domain.usecases.room;

import com.am.scheduling.data.database.models.Room;
import com.am.scheduling.domain.base.input.CompletableCase;
import com.am.scheduling.domain.repositories.room.RoomRepo;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CreateRoomCase extends CompletableCase<Room> {

    @Inject
    RoomRepo repo;

    @Inject
    public CreateRoomCase() {
    }

    @Override
    protected Completable buildTask(Room data) {
        return repo.save(data);
    }
}
