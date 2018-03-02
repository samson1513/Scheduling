package com.am.scheduling.domain.usecases.teacher;

import com.am.scheduling.domain.base.single.SingleAsyncUseCase;
import com.am.scheduling.domain.repositories.teacher.TeacherRepo;
import com.am.scheduling.presentation.screens.main.managment.teacher.adapter.TeacherDH;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class TeacherListCase extends SingleAsyncUseCase<List<TeacherDH>> {

    @Inject
    TeacherRepo mTeacherRepo;

    @Inject
    public TeacherListCase() {
    }

    @Override
    protected Single<List<TeacherDH>> buildTask() {
        return mTeacherRepo.get();
    }
}
