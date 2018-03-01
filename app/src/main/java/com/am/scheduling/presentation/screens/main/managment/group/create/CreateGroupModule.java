package com.am.scheduling.presentation.screens.main.managment.group.create;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Module
public abstract class CreateGroupModule {

    @Binds
    abstract CreateGroupContract.Presenter presenter(CreateGroupPresenter presenter);
}
