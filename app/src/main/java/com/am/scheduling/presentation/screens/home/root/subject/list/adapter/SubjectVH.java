package com.am.scheduling.presentation.screens.home.root.subject.list.adapter;

import android.view.View;
import android.widget.TextView;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.list.adapter.BaseVH;

import butterknife.BindView;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class SubjectVH extends BaseVH<SubjectDH> {

    @BindView(R.id.text_subject_name_is)
    TextView mTextSubjectNameIs;

    public SubjectVH(View view) {
        super(view);
    }

    @Override
    public void bindData(SubjectDH data) {
        mTextSubjectNameIs.setText(data.model.name);
    }
}
