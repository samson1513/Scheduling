package com.am.scheduling.presentation.screens.main.managment.room;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.am.scheduling.presentation.core.list.ListFragment;
import com.am.scheduling.presentation.core.list.adapter.SimpleAdapter;
import com.am.scheduling.presentation.screens.main.managment.room.adapter.RoomDH;
import com.am.scheduling.presentation.screens.main.managment.room.adapter.RoomsAdapter;
import com.am.scheduling.presentation.screens.main.managment.room.create.CreateRoomFragment;
import com.am.scheduling.presentation.utils.Consts;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class RoomsFragment extends ListFragment<RoomDH, RoomsContract.Presenter>
        implements RoomsContract.View {

    @Inject
    RoomsContract.Presenter mPresenter;

    @Inject
    RoomsAdapter mAdapter;

    @Override
    public RoomsContract.Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected SimpleAdapter<RoomDH> getAdapter() {
        return mAdapter;
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState) {
        getPresenter().loadData();
    }

    @Override
    public void startCreateRoomScreen() {
        getNavigator().showFragment(new CreateRoomFragment());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Consts.RC_CREATE) {
            getPresenter().createRoom();
        }
    }
}
