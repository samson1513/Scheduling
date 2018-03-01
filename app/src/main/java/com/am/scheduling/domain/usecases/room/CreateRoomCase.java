package com.am.scheduling.domain.usecases.room;

import com.am.scheduling.data.database.models.Room;
import com.am.scheduling.domain.base.completable.CompletableAsyncUseCase;
import com.am.scheduling.domain.repositories.room.RoomRepo;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CreateRoomCase extends CompletableAsyncUseCase {

    @Inject
    RoomRepo mRoomRepo;
    private Room mRoom;

    @Inject
    public CreateRoomCase() {
    }

    public CreateRoomCase with(String name, int capacity) {
        mRoom = new Room();
        mRoom.setName(name);
        mRoom.setCapacity(capacity);
        return this;
    }

    @Override
    protected Completable buildTask() {
        return mRoomRepo.save(mRoom);
    }
}
