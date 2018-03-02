package com.am.scheduling.presentation.screens.main.managment.teacher.adapter;

import android.view.View;
import android.widget.TextView;

import com.am.scheduling.R;
import com.am.scheduling.presentation.core.list.adapter.BaseVH;

import butterknife.BindView;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class TeacherVH extends BaseVH<TeacherDH> {

    @BindView(R.id.text_full_name_it)
    TextView mTextFullNameIt;

    public TeacherVH(View view) {
        super(view);
    }

    @Override
    public void bindData(TeacherDH data) {
        mTextFullNameIt.setText(data.model.getFullName());
    }
}
