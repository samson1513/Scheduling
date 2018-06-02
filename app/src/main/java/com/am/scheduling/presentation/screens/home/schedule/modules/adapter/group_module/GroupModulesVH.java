package com.am.scheduling.presentation.screens.home.schedule.modules.adapter.group_module;

import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.list.pager.ClickableVH;
import com.am.scheduling.presentation.abc.core.list.pager.OnItemClickListener;
import com.am.scheduling.presentation.abc.core.list.pager.PagerVH;
import com.am.scheduling.presentation.screens.home.schedule.modules.adapter.module.ModuleAdapter;
import com.am.scheduling.presentation.utils.ui.RxView;

import butterknife.BindView;

/**
 * Created by Alex Michenko
 * on 01.06.2018.
 */
public class GroupModulesVH extends PagerVH<GroupModulesDH> implements ClickableVH {

    @BindView(R.id.et_subject_fgm)
    EditText mEtSubjectFgm;
    @BindView(R.id.et_teacher_fgm)
    EditText mEtTeacherFgm;
    @BindView(R.id.et_count_fgm)
    EditText mEtCountFgm;
    @BindView(R.id.btn_add_fgm)
    Button mBtnAddFgm;
    @BindView(R.id.rv_modules_fgm)
    RecyclerView mRvModulesFgm;
    @BindView(R.id.til_subject_fgm)
    TextInputLayout mTilSubjectFgm;
    @BindView(R.id.til_teacher_fgm)
    TextInputLayout mTilTeacherFgm;
    @BindView(R.id.til_count_fgm)
    TextInputLayout mTilCountFgm;

    private ModuleAdapter adapter;

    public GroupModulesVH(View itemView) {
        super(itemView);
        adapter = new ModuleAdapter();
        mRvModulesFgm.setAdapter(adapter);
        mRvModulesFgm.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        RxView.safeClicks(mEtSubjectFgm)
                .subscribe(o -> onItemClickListener.onItemClick(mEtSubjectFgm, position));
        RxView.safeClicks(mEtTeacherFgm)
                .subscribe(o -> onItemClickListener.onItemClick(mEtTeacherFgm, position));
        RxView.safeClicks(mBtnAddFgm)
                .subscribe(o -> onItemClickListener.onItemClick(mBtnAddFgm, position));
        RxView.textChanged(mEtCountFgm)
                .subscribe(o -> onItemClickListener.onItemClick(mEtCountFgm, position));
    }

    @Override
    public void bindData(GroupModulesDH data) {
        mEtSubjectFgm.setText(data.getCurrentSubject());
        mEtTeacherFgm.setText(data.getCurrentTeacher());
        mEtCountFgm.setText(String.valueOf(data.getCurrentCount()));
        adapter.setNewData(data.moduleDHS);
        adapter.setOnItemClickListener((adapter1, view, position1) -> {
            adapter.remove(position1);
            data.moduleDHS.remove(position1);
        });

        if (data.error) {
            if (data.currentModule.subject == null)
                mTilSubjectFgm.setError("Required");
            else
                mTilSubjectFgm.setError(null);
            if (data.currentModule.teacher == null)
                mTilTeacherFgm.setError("Required");
            else
                mTilTeacherFgm.setError(null);
            if (data.currentModule.count == 0)
                mTilCountFgm.setError("Must be positive");
            else
                mTilCountFgm.setError(null);
        }
    }
}
