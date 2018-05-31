package com.am.scheduling.domain.usecases.teacher;

import com.am.scheduling.data.database.models.Teacher;
import com.am.scheduling.domain.base.no_input.NoInputSingleCase;
import com.am.scheduling.domain.repositories.teacher.TeacherRepo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class TeacherListCase extends NoInputSingleCase<List<Teacher>> {

    @Inject
    TeacherRepo repo;

    @Inject
    public TeacherListCase() {
    }

    @Override
    protected Single<List<Teacher>> buildTask() {
        return repo.get();
    }
}
