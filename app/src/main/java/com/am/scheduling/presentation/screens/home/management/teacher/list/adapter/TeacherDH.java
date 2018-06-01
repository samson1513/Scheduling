package com.am.scheduling.presentation.screens.home.management.teacher.list.adapter;

import com.am.scheduling.data.database.models.Teacher;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class TeacherDH implements MultiItemEntity {

    public Teacher model;

    public TeacherDH(Teacher model) {
        this.model = model;
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
