package com.am.scheduling.presentation.screens.main.managment.teacher.adapter;

import android.view.View;

import com.am.scheduling.R;
import com.am.scheduling.presentation.core.list.adapter.BaseVH;
import com.am.scheduling.presentation.core.list.adapter.DelegateVH;
import com.am.scheduling.presentation.core.list.adapter.SimpleAdapter;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class TeachersAdapter extends SimpleAdapter<TeacherDH> {

    @Inject
    public TeachersAdapter() {
    }

    @Override
    protected void initViewTypes() {
        addViewType(0, R.layout.item_teacher, new DelegateVH<TeacherDH>() {
            @Override
            public BaseVH<TeacherDH> createVH(View view) {
                return new TeacherVH(view);
            }
        });
    }
}
