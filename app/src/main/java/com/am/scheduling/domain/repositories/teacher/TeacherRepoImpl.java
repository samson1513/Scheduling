package com.am.scheduling.domain.repositories.teacher;

import com.am.scheduling.data.database.dao.TeacherDao;
import com.am.scheduling.data.database.models.Teacher;
import com.am.scheduling.domain.repositories.teacher.mapper.TeacherMapper;
import com.am.scheduling.presentation.screens.main.managment.teacher.adapter.TeacherDH;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class TeacherRepoImpl implements TeacherRepo {

    private TeacherDao mTeacherDao;
    private TeacherMapper mTeacherMapper;

    @Inject
    public TeacherRepoImpl(TeacherDao roomDao, TeacherMapper teacherMapper) {
        mTeacherDao = roomDao;
        mTeacherMapper = teacherMapper;
    }

    @Override
    public Single<List<TeacherDH>> get() {
        return mTeacherDao.get()
                .flatMapObservable(Observable::fromIterable)
                .map(mTeacherMapper::convert)
                .toList();
    }

    @Override
    public Completable save(Teacher group) {
        return Completable.fromCallable(() -> mTeacherDao.insert(group));
    }
}
