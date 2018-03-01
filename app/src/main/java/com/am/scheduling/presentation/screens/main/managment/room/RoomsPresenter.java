package com.am.scheduling.presentation.screens.main.managment.room;

import com.am.scheduling.domain.base.single.DefaultSingleObserver;
import com.am.scheduling.domain.usecases.room.RoomListCase;
import com.am.scheduling.presentation.core.list.ListPresenterImpl;
import com.am.scheduling.presentation.screens.main.managment.room.adapter.RoomDH;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class RoomsPresenter extends ListPresenterImpl<RoomsContract.View>
        implements RoomsContract.Presenter {

    private RoomListCase mRoomListCase;

    @Inject
    public RoomsPresenter(RoomListCase roomListCase) {
        mRoomListCase = roomListCase;
    }

    @Override
    public void loadData() {
        addDisposable(mRoomListCase.execute(new RoomsObserver()));
    }

    @Override
    public void createRoom() {
        getView().startCreateRoomScreen();
    }

    class RoomsObserver extends DefaultSingleObserver<List<RoomDH>> {

        @Override
        public void onSuccess(List<RoomDH> roomDHS) {
            getView().setItems(roomDHS);
        }
    }
}
