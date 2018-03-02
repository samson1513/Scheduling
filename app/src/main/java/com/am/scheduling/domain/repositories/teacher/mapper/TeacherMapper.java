package com.am.scheduling.domain.repositories.teacher.mapper;

import com.am.scheduling.data.database.models.Teacher;
import com.am.scheduling.presentation.screens.main.managment.teacher.adapter.TeacherDH;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class TeacherMapper {

    @Inject
    public TeacherMapper() {
    }

    public TeacherDH convert(Teacher model) {
        return new TeacherDH(model);
    }
}
