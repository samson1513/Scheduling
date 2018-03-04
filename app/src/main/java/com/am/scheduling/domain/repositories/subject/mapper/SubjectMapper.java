package com.am.scheduling.domain.repositories.subject.mapper;

import com.am.scheduling.data.database.models.Subject;
import com.am.scheduling.presentation.screens.main.managment.subject.adapter.SubjectDH;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class SubjectMapper {

    @Inject
    public SubjectMapper() {
    }

    public SubjectDH convert(Subject model) {
        return new SubjectDH(model);
    }
}
