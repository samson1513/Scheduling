package com.am.scheduling.di.modules;


import com.am.scheduling.domain.repositories.ga.GenRepo;
import com.am.scheduling.domain.repositories.ga.GenRepoImpl;
import com.am.scheduling.domain.repositories.group.GroupRepo;
import com.am.scheduling.domain.repositories.group.GroupRepoImpl;
import com.am.scheduling.domain.repositories.room.RoomRepo;
import com.am.scheduling.domain.repositories.room.RoomRepoImpl;
import com.am.scheduling.domain.repositories.subject.SubjectRepo;
import com.am.scheduling.domain.repositories.subject.SubjectRepoImpl;
import com.am.scheduling.domain.repositories.teacher.TeacherRepo;
import com.am.scheduling.domain.repositories.teacher.TeacherRepoImpl;
import com.am.scheduling.domain.repositories.timeslot.TimeslotRepo;
import com.am.scheduling.domain.repositories.timeslot.TimeslotRepoImpl;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

@Module
public abstract class RepositoryModule {

    @Binds
    abstract RoomRepo roomRepo(RoomRepoImpl roomRepoImpl);

    @Binds
    abstract GroupRepo groupRepo(GroupRepoImpl groupRepoImpl);

    @Binds
    abstract TeacherRepo teacherRepo(TeacherRepoImpl teacherRepoImpl);

    @Binds
    abstract SubjectRepo subjectRepo(SubjectRepoImpl subjectRepoImpl);

    @Binds
    abstract TimeslotRepo timeslotRepo(TimeslotRepoImpl timeslotRepoImpl);

    @Binds
    abstract GenRepo genRepo(GenRepoImpl genRepoImpl);
}
