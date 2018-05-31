package com.am.scheduling.domain.usecases.subject;

import com.am.scheduling.data.database.models.Subject;
import com.am.scheduling.domain.base.input.CompletableCase;
import com.am.scheduling.domain.repositories.subject.SubjectRepo;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CreateSubjectCase extends CompletableCase<Subject> {

    @Inject
    SubjectRepo repo;

    @Inject
    public CreateSubjectCase() {
    }

    @Override
    protected Completable buildTask(Subject data) {
        return repo.save(data);
    }
}
