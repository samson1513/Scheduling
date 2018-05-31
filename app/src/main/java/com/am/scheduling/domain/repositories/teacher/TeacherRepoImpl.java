package com.am.scheduling.domain.repositories.teacher;

import com.am.scheduling.data.database.dao.TeacherDao;
import com.am.scheduling.data.database.models.Teacher;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class TeacherRepoImpl implements TeacherRepo {

    @Inject
    protected TeacherDao mTeacherDao;

    @Inject
    public TeacherRepoImpl() {
    }

    @Override
    public Single<List<Teacher>> get() {
        return Single.just(mTeacherDao.get());
    }

    @Override
    public Completable save(Teacher group) {
        return Completable.fromAction(() -> mTeacherDao.insert(group));
    }
}
