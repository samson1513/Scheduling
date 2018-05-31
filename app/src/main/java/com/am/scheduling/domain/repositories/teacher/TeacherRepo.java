package com.am.scheduling.domain.repositories.teacher;

import com.am.scheduling.data.database.models.Teacher;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public interface TeacherRepo {

    Single<List<Teacher>> get();

    Completable save(Teacher model);
}
