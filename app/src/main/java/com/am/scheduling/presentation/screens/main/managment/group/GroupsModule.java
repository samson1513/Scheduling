package com.am.scheduling.presentation.screens.main.managment.group;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */
@Module
public abstract class GroupsModule {

    @Binds
    abstract GroupsContract.Presenter presenter(GroupsPresenter presenter);

}
