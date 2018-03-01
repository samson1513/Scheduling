package com.am.scheduling.domain.usecases.room;

import com.am.scheduling.domain.base.single.SingleAsyncUseCase;
import com.am.scheduling.domain.repositories.room.RoomRepo;
import com.am.scheduling.presentation.screens.main.managment.room.adapter.RoomDH;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class RoomListCase extends SingleAsyncUseCase<List<RoomDH>> {

    @Inject
    RoomRepo mRoomRepo;

    @Inject
    public RoomListCase() {
    }

    @Override
    protected Single<List<RoomDH>> buildTask() {
        return mRoomRepo.getRooms();
    }
}
