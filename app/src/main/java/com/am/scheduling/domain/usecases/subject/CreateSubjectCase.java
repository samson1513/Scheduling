package com.am.scheduling.domain.usecases.subject;

import com.am.scheduling.data.database.models.Subject;
import com.am.scheduling.domain.base.completable.CompletableAsyncUseCase;
import com.am.scheduling.domain.repositories.subject.SubjectRepo;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CreateSubjectCase extends CompletableAsyncUseCase {

    @Inject
    SubjectRepo mSubjectRepo;
    private Subject mSubject;

    @Inject
    public CreateSubjectCase() {
    }

    public CreateSubjectCase with(String name) {
        mSubject = new Subject();
        mSubject.setName(name);
        return this;
    }

    @Override
    protected Completable buildTask() {
        return mSubjectRepo.save(mSubject);
    }
}
