package com.am.scheduling.domain.usecases.room;

import com.am.scheduling.data.database.models.Room;
import com.am.scheduling.domain.base.no_input.NoInputSingleCase;
import com.am.scheduling.domain.repositories.room.RoomRepo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class RoomListCase extends NoInputSingleCase<List<Room>> {

    @Inject
    RoomRepo repo;

    @Inject
    public RoomListCase() {
    }

    @Override
    protected Single<List<Room>> buildTask() {
        return repo.getRooms();
    }
}
