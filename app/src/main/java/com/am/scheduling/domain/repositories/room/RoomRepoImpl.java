package com.am.scheduling.domain.repositories.room;

import com.am.scheduling.data.database.dao.RoomDao;
import com.am.scheduling.data.database.models.Room;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class RoomRepoImpl implements RoomRepo {

    @Inject
    RoomDao mRoomDao;

    @Inject
    public RoomRepoImpl() {
    }

    @Override
    public Single<List<Room>> getRooms() {
        return Single.just(mRoomDao.get());
    }

    @Override
    public Completable save(Room room) {
        return Completable.fromAction(() -> mRoomDao.insert(room));
    }
}
