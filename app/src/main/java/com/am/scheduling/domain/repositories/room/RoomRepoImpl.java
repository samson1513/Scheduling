package com.am.scheduling.domain.repositories.room;

import com.am.scheduling.data.database.dao.RoomDao;
import com.am.scheduling.data.database.models.Room;
import com.am.scheduling.domain.repositories.room.mapper.RoomMapper;
import com.am.scheduling.presentation.screens.main.managment.room.adapter.RoomDH;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class RoomRepoImpl implements RoomRepo {

    private RoomDao mRoomDao;
    private RoomMapper mRoomMapper;

    @Inject
    public RoomRepoImpl(RoomDao roomDao, RoomMapper roomMapper) {
        mRoomDao = roomDao;
        mRoomMapper = roomMapper;
    }

    @Override
    public Single<List<RoomDH>> getRooms() {
        return mRoomDao.getRooms()
                .flatMapObservable(Observable::fromIterable)
                .map(mRoomMapper::convert)
                .toList();
    }

    @Override
    public Completable save(Room room) {
        return Completable.fromCallable(() -> mRoomDao.insert(room));
    }
}
