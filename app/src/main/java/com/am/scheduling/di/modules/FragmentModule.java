package com.am.scheduling.di.modules;


import com.am.scheduling.presentation.screens.home.management.ManagementContract;
import com.am.scheduling.presentation.screens.home.management.ManagementFragment;
import com.am.scheduling.presentation.screens.home.management.group.create.CreateGroupContract;
import com.am.scheduling.presentation.screens.home.management.group.create.CreateGroupFragment;
import com.am.scheduling.presentation.screens.home.management.group.list.GroupListContract;
import com.am.scheduling.presentation.screens.home.management.group.list.GroupListFragment;
import com.am.scheduling.presentation.screens.home.management.room.create.CreateRoomContract;
import com.am.scheduling.presentation.screens.home.management.room.create.CreateRoomFragment;
import com.am.scheduling.presentation.screens.home.management.room.list.RoomListContract;
import com.am.scheduling.presentation.screens.home.management.room.list.RoomListFragment;
import com.am.scheduling.presentation.screens.home.management.subject.create.CreateSubjectContract;
import com.am.scheduling.presentation.screens.home.management.subject.create.CreateSubjectFragment;
import com.am.scheduling.presentation.screens.home.management.subject.list.SubjectListContract;
import com.am.scheduling.presentation.screens.home.management.subject.list.SubjectListFragment;
import com.am.scheduling.presentation.screens.home.management.teacher.create.CreateTeacherContract;
import com.am.scheduling.presentation.screens.home.management.teacher.create.CreateTeacherFragment;
import com.am.scheduling.presentation.screens.home.management.teacher.list.TeacherListContract;
import com.am.scheduling.presentation.screens.home.management.teacher.list.TeacherListFragment;
import com.am.scheduling.presentation.screens.home.management.timeslot.create.CreateTimeslotContract;
import com.am.scheduling.presentation.screens.home.management.timeslot.create.CreateTimeslotFragment;
import com.am.scheduling.presentation.screens.home.management.timeslot.list.TimeslotListContract;
import com.am.scheduling.presentation.screens.home.management.timeslot.list.TimeslotListFragment;
import com.am.scheduling.presentation.screens.home.root.RootContract;
import com.am.scheduling.presentation.screens.home.root.RootFragment;
import com.am.scheduling.presentation.screens.home.schedule.generator.GeneratorContract;
import com.am.scheduling.presentation.screens.home.schedule.generator.GeneratorFragment;
import com.am.scheduling.presentation.screens.home.schedule.grouppicker.GroupPickerContract;
import com.am.scheduling.presentation.screens.home.schedule.grouppicker.GroupPickerFragment;
import com.am.scheduling.presentation.screens.home.schedule.modules.ModulesContract;
import com.am.scheduling.presentation.screens.home.schedule.modules.ModulesFragment;
import com.am.scheduling.presentation.screens.home.schedule.modules.picker.subject.SubjectPickerContract;
import com.am.scheduling.presentation.screens.home.schedule.modules.picker.subject.SubjectPickerDialog;
import com.am.scheduling.presentation.screens.home.schedule.modules.picker.teacher.TeacherPickerContract;
import com.am.scheduling.presentation.screens.home.schedule.modules.picker.teacher.TeacherPickerDialog;
import com.am.scheduling.presentation.screens.home.schedule.timeslotpicker.TimeslotPickerContract;
import com.am.scheduling.presentation.screens.home.schedule.timeslotpicker.TimeslotPickerFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

@Module
public abstract class FragmentModule {

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

    @ContributesAndroidInjector(modules = {GroupPickerContract.GroupPickerModule.class})
    abstract GroupPickerFragment groupPickerFragment();

    @ContributesAndroidInjector(modules = {SubjectPickerContract.SubjectPickerModule.class})
    abstract SubjectPickerDialog subjectPickerDialog();

    @ContributesAndroidInjector(modules = {TeacherPickerContract.TeacherPickerModule.class})
    abstract TeacherPickerDialog teacherPickerDialog();

    @ContributesAndroidInjector(modules = {ModulesContract.ModulesModule.class})
    abstract ModulesFragment modulesFragment();

    @ContributesAndroidInjector(modules = {TimeslotPickerContract.TimeslotPickerModule.class})
    abstract TimeslotPickerFragment timeslotpickerFragment();

    @ContributesAndroidInjector(modules = {GeneratorContract.GeneratorModule.class})
    abstract GeneratorFragment generatorFragment();
}
