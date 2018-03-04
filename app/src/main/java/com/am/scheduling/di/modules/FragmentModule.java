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
import com.am.scheduling.presentation.screens.main.managment.schedule.SchedulesFragment;
import com.am.scheduling.presentation.screens.main.managment.schedule.SchedulesModule;
import com.am.scheduling.presentation.screens.main.managment.schedule.create.CreateScheduleFragment;
import com.am.scheduling.presentation.screens.main.managment.schedule.create.CreateScheduleModule;
import com.am.scheduling.presentation.screens.main.managment.subject.SubjectsFragment;
import com.am.scheduling.presentation.screens.main.managment.subject.SubjectsModule;
import com.am.scheduling.presentation.screens.main.managment.subject.create.CreateSubjectFragment;
import com.am.scheduling.presentation.screens.main.managment.subject.create.CreateSubjectModule;
import com.am.scheduling.presentation.screens.main.managment.teacher.TeachersFragment;
import com.am.scheduling.presentation.screens.main.managment.teacher.TeachersModule;
import com.am.scheduling.presentation.screens.main.managment.teacher.create.CreateTeacherFragment;
import com.am.scheduling.presentation.screens.main.managment.teacher.create.CreateTeacherModule;

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

    @ContributesAndroidInjector(modules = {TeachersModule.class})
    abstract TeachersFragment teachersFragment();

    @ContributesAndroidInjector(modules = {CreateTeacherModule.class})
    abstract CreateTeacherFragment createTeacherFragment();

    @ContributesAndroidInjector(modules = {SubjectsModule.class})
    abstract SubjectsFragment subjectsFragment();

    @ContributesAndroidInjector(modules = {CreateSubjectModule.class})
    abstract CreateSubjectFragment createSubjectFragment();

    @ContributesAndroidInjector(modules = {SchedulesModule.class})
    abstract SchedulesFragment schedulesFragment();

    @ContributesAndroidInjector(modules = {CreateScheduleModule.class})
    abstract CreateScheduleFragment createScheduleFragment();

}
