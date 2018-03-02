package com.am.scheduling.domain.usecases.teacher;

import com.am.scheduling.data.database.models.Teacher;
import com.am.scheduling.domain.base.completable.CompletableAsyncUseCase;
import com.am.scheduling.domain.repositories.teacher.TeacherRepo;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CreateTeacherCase extends CompletableAsyncUseCase {

    @Inject
    TeacherRepo mTeacherRepo;
    private Teacher mTeacher;

    @Inject
    public CreateTeacherCase() {
    }

    public CreateTeacherCase with(String first, String last) {
        mTeacher = new Teacher();
        mTeacher.setFirstName(first);
        mTeacher.setLastName(last);
        return this;
    }

    @Override
    protected Completable buildTask() {
        return mTeacherRepo.save(mTeacher);
    }
}
