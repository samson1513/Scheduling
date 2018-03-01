package com.am.scheduling.presentation.screens.main.managment.room;

import com.am.scheduling.presentation.core.list.ListPresenter;
import com.am.scheduling.presentation.core.list.ListView;
import com.am.scheduling.presentation.screens.main.managment.room.adapter.RoomDH;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public interface RoomsContract {

    interface View extends ListView<RoomDH, Presenter> {
        void startCreateRoomScreen();
    }

    interface Presenter extends ListPresenter<View> {
        void createRoom();
    }
}
