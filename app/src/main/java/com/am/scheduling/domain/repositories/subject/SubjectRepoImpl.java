package com.am.scheduling.domain.repositories.subject;

import com.am.scheduling.data.database.dao.SubjectDao;
import com.am.scheduling.data.database.models.Subject;
import com.am.scheduling.domain.repositories.subject.mapper.SubjectMapper;
import com.am.scheduling.presentation.screens.main.managment.subject.adapter.SubjectDH;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class SubjectRepoImpl implements SubjectRepo {

    private SubjectDao mSubjectDao;
    private SubjectMapper mSubjectMapper;

    @Inject
    public SubjectRepoImpl(SubjectDao roomDao, SubjectMapper subjectMapper) {
        mSubjectDao = roomDao;
        mSubjectMapper = subjectMapper;
    }

    @Override
    public Single<List<SubjectDH>> get() {
        return mSubjectDao.get()
                .flatMapObservable(Observable::fromIterable)
                .map(mSubjectMapper::convert)
                .toList();
    }

    @Override
    public Completable save(Subject group) {
        return Completable.fromCallable(() -> mSubjectDao.insert(group));
    }
}
