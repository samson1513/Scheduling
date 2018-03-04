package com.am.scheduling.domain.usecases.subject;

import com.am.scheduling.domain.base.single.SingleAsyncUseCase;
import com.am.scheduling.domain.repositories.subject.SubjectRepo;
import com.am.scheduling.presentation.screens.main.managment.subject.adapter.SubjectDH;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class SubjectListCase extends SingleAsyncUseCase<List<SubjectDH>> {

    @Inject
    SubjectRepo mSubjectRepo;

    @Inject
    public SubjectListCase() {
    }

    @Override
    protected Single<List<SubjectDH>> buildTask() {
        return mSubjectRepo.get();
    }
}
