package com.am.scheduling.presentation.screens.main.managment.room;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */
@Module
public abstract class RoomsModule {

    @Binds
    abstract RoomsContract.Presenter presenter(RoomsPresenter presenter);

}
