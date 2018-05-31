package com.am.scheduling.domain.repositories.room;

import com.am.scheduling.data.database.models.Room;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public interface RoomRepo {

    Single<List<Room>> getRooms();

    Completable save(Room room);
}
