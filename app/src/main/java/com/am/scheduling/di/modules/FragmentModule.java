package com.am.scheduling.di.modules;


import com.am.scheduling.presentation.screens.main.managment.ManagementFragment;
import com.am.scheduling.presentation.screens.main.managment.ManagementModule;
import com.am.scheduling.presentation.screens.main.managment.group.GroupsFragment;
import com.am.scheduling.presentation.screens.main.managment.group.GroupsModule;
import com.am.scheduling.presentation.screens.main.managment.group.create.CreateGroupFragment;
import com.am.scheduling.presentation.screens.main.managment.group.create.CreateGroupModule;
import com.am.scheduling.presentation.screens.main.managment.room.RoomsFragment;
import com.am.scheduling.presentation.screens.main.managment.room.RoomsModule;
import com.am.scheduling.presentation.screens.main.managment.room.create.CreateRoomFragment;
import com.am.scheduling.presentation.screens.main.managment.room.create.CreateRoomModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector(modules = {ManagementModule.class})
    abstract ManagementFragment managementFragment();

    @ContributesAndroidInjector(modules = {RoomsModule.class})
    abstract RoomsFragment roomsFragment();

    @ContributesAndroidInjector(modules = {CreateRoomModule.class})
    abstract CreateRoomFragment createRoomFragment();

    @ContributesAndroidInjector(modules = {GroupsModule.class})
    abstract GroupsFragment groupsFragment();

    @ContributesAndroidInjector(modules = {CreateGroupModule.class})
    abstract CreateGroupFragment createGroupFragment();

}
