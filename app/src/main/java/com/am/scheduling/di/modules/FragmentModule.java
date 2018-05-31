package com.am.scheduling.di.modules;


import com.am.scheduling.presentation.screens.home.root.RootContract;
import com.am.scheduling.presentation.screens.home.root.RootFragment;
import com.am.scheduling.presentation.screens.home.root.group.create.CreateGroupContract;
import com.am.scheduling.presentation.screens.home.root.group.create.CreateGroupFragment;
import com.am.scheduling.presentation.screens.home.root.group.list.GroupListContract;
import com.am.scheduling.presentation.screens.home.root.group.list.GroupListFragment;
import com.am.scheduling.presentation.screens.home.root.management.ManagementContract;
import com.am.scheduling.presentation.screens.home.root.management.ManagementFragment;
import com.am.scheduling.presentation.screens.home.root.room.create.CreateRoomContract;
import com.am.scheduling.presentation.screens.home.root.room.create.CreateRoomFragment;
import com.am.scheduling.presentation.screens.home.root.room.list.RoomListContract;
import com.am.scheduling.presentation.screens.home.root.room.list.RoomListFragment;
import com.am.scheduling.presentation.screens.home.root.subject.create.CreateSubjectContract;
import com.am.scheduling.presentation.screens.home.root.subject.create.CreateSubjectFragment;
import com.am.scheduling.presentation.screens.home.root.subject.list.SubjectListContract;
import com.am.scheduling.presentation.screens.home.root.subject.list.SubjectListFragment;
import com.am.scheduling.presentation.screens.home.root.teacher.create.CreateTeacherContract;
import com.am.scheduling.presentation.screens.home.root.teacher.create.CreateTeacherFragment;
import com.am.scheduling.presentation.screens.home.root.teacher.list.TeacherListContract;
import com.am.scheduling.presentation.screens.home.root.teacher.list.TeacherListFragment;
import com.am.scheduling.presentation.screens.home.root.timeslot.create.CreateTimeslotContract;
import com.am.scheduling.presentation.screens.home.root.timeslot.create.CreateTimeslotFragment;
import com.am.scheduling.presentation.screens.home.root.timeslot.list.TimeslotListContract;
import com.am.scheduling.presentation.screens.home.root.timeslot.list.TimeslotListFragment;
import com.am.scheduling.presentation.screens.main.creator.CreatorFragment;
import com.am.scheduling.presentation.screens.main.creator.CreatorModule;
import com.am.scheduling.presentation.screens.main.groupmodules.GroupModulesContract;
import com.am.scheduling.presentation.screens.main.groupmodules.GroupModulesFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector(modules = {CreatorModule.class})
    abstract CreatorFragment creatorFragment();

    @ContributesAndroidInjector(modules = {RootContract.RootModule.class})
    abstract RootFragment rootFragment();

    @ContributesAndroidInjector(modules = {ManagementContract.ManagementModule.class})
    abstract ManagementFragment managementFragment();

    @ContributesAndroidInjector(modules = {GroupListContract.GroupListModule.class})
    abstract GroupListFragment grouplistFragment();

    @ContributesAndroidInjector(modules = {CreateGroupContract.CreateGroupModule.class})
    abstract CreateGroupFragment creategroupFragment();

    @ContributesAndroidInjector(modules = {RoomListContract.RoomListModule.class})
    abstract RoomListFragment roomListFragment();

    @ContributesAndroidInjector(modules = {CreateRoomContract.CreateRoomModule.class})
    abstract CreateRoomFragment createroomFragment();

    @ContributesAndroidInjector(modules = {SubjectListContract.SubjectListModule.class})
    abstract SubjectListFragment subjectListFragment();

    @ContributesAndroidInjector(modules = {CreateSubjectContract.CreateSubjectModule.class})
    abstract CreateSubjectFragment createSubjectFragment();

    @ContributesAndroidInjector(modules = {TeacherListContract.TeacherListModule.class})
    abstract TeacherListFragment teacherListFragment();

    @ContributesAndroidInjector(modules = {CreateTeacherContract.CreateTeacherModule.class})
    abstract CreateTeacherFragment createTeacherFragment();

    @ContributesAndroidInjector(modules = {TimeslotListContract.TimeslotListModule.class})
    abstract TimeslotListFragment timeslotListFragment();

    @ContributesAndroidInjector(modules = {CreateTimeslotContract.CreateTimeslotModule.class})
    abstract CreateTimeslotFragment createTimeslotFragment();

    @ContributesAndroidInjector(modules = {GroupModulesContract.GroupModulesModule.class})
    abstract GroupModulesFragment groupmodulesFragment();
}
