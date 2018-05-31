package com.am.scheduling.domain.repositories.subject;

import com.am.scheduling.data.database.dao.SubjectDao;
import com.am.scheduling.data.database.models.Subject;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class SubjectRepoImpl implements SubjectRepo {

    @Inject
    SubjectDao mSubjectDao;

    @Inject
    public SubjectRepoImpl() {
    }

    @Override
    public Single<List<Subject>> get() {
        return Single.just(mSubjectDao.get());
    }

    @Override
    public Completable save(Subject group) {
        return Completable.fromAction(() -> mSubjectDao.insert(group));
    }
}
