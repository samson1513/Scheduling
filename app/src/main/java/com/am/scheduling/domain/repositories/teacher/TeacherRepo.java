package com.am.scheduling.domain.repositories.teacher;

import com.am.scheduling.data.database.models.Teacher;
import com.am.scheduling.presentation.screens.main.managment.teacher.adapter.TeacherDH;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public interface TeacherRepo {

    Single<List<TeacherDH>> get();

    Completable save(Teacher model);
}
