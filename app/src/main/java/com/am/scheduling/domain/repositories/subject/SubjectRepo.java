package com.am.scheduling.domain.repositories.subject;

import com.am.scheduling.data.database.models.Subject;
import com.am.scheduling.presentation.screens.main.managment.subject.adapter.SubjectDH;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public interface SubjectRepo {

    Single<List<SubjectDH>> get();

    Completable save(Subject model);
}
