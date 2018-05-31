package com.am.scheduling.domain.usecases.subject;

import com.am.scheduling.data.database.models.Subject;
import com.am.scheduling.domain.base.no_input.NoInputSingleCase;
import com.am.scheduling.domain.repositories.subject.SubjectRepo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class SubjectListCase extends NoInputSingleCase<List<Subject>> {

    @Inject
    SubjectRepo repo;

    @Inject
    public SubjectListCase() {
    }

    @Override
    protected Single<List<Subject>> buildTask() {
        return repo.get();
    }
}
