package com.am.scheduling.domain.usecases.teacher;

import com.am.scheduling.data.database.models.Teacher;
import com.am.scheduling.domain.base.input.CompletableCase;
import com.am.scheduling.domain.repositories.teacher.TeacherRepo;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CreateTeacherCase extends CompletableCase<Teacher> {

    @Inject
    TeacherRepo repo;

    @Inject
    public CreateTeacherCase() {
    }

    @Override
    protected Completable buildTask(Teacher data) {
        return repo.save(data);
    }
}
