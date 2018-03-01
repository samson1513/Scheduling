package com.am.scheduling.presentation.screens.main.managment.room.create;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Module
public abstract class CreateRoomModule {

    @Binds
    abstract CreateRoomContract.Presenter presenter(CreateRoomPresenter presenter);
}
