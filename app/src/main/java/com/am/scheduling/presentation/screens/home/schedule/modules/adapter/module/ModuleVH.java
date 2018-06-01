package com.am.scheduling.presentation.screens.home.schedule.modules.adapter.module;

import android.view.View;
import android.widget.TextView;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.list.adapter.BaseVH;

import butterknife.BindView;

/**
 * Created by Alex Michenko
 * on 31.05.2018.
 */
public class ModuleVH extends BaseVH<ModuleDH> {

    @BindView(R.id.tv_subject)
    TextView mTvSubject;
    @BindView(R.id.tv_count)
    TextView mTvCount;
    @BindView(R.id.tv_teacher)
    TextView mTvTeacher;

    public ModuleVH(View view) {
        super(view);
    }

    @Override
    public void bindData(ModuleDH data) {
        mTvSubject.setText(data.subject.name);
        mTvCount.setText(String.valueOf(data.count));
        mTvTeacher.setText(data.teacher.fullName);
    }
}
