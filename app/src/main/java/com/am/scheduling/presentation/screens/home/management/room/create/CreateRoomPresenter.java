package com.am.scheduling.presentation.screens.home.management.room.create;

import android.text.TextUtils;

import com.am.scheduling.data.database.models.Room;
import com.am.scheduling.presentation.abc.core.base.BasePresenterImpl;

public class CreateRoomPresenter extends BasePresenterImpl<CreateRoomContract.View> implements CreateRoomContract.Presenter {

    private CreateRoomContract.Model model;

    public CreateRoomPresenter(CreateRoomContract.View view, CreateRoomContract.Model model) {
        super(view);
        this.model = model;
    }

    @Override
    public void save(String name, String capacity) {
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(capacity)) {
            addDisposable(model.mCreateRoomCase.async(new Room(name, Integer.parseInt(capacity)))
                    .subscribe(getView()::finish, Throwable::printStackTrace)
            );
        }
    }

    @Override
    public void subscribe() {

    }
}