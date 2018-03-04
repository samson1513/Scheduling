package com.am.scheduling.presentation.screens.main.managment.subject.adapter;

import com.am.scheduling.data.database.models.Subject;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class SubjectDH implements MultiItemEntity {

    public Subject model;

    public SubjectDH(Subject model) {
        this.model = model;
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
