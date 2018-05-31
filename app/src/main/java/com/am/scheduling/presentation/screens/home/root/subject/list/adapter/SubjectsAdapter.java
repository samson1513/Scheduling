package com.am.scheduling.presentation.screens.home.root.subject.list.adapter;

import android.view.View;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.list.adapter.BaseVH;
import com.am.scheduling.presentation.abc.core.list.adapter.DelegateVH;
import com.am.scheduling.presentation.abc.core.list.adapter.SimpleAdapter;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class SubjectsAdapter extends SimpleAdapter<SubjectDH> {

    @Inject
    public SubjectsAdapter() {
    }

    @Override
    protected void initViewTypes(ViewTypeBuilder builder) {
        builder.addViewType(0, R.layout.item_subject, new DelegateVH<SubjectDH>() {
            @Override
            public BaseVH<SubjectDH> createVH(View view) {
                return new SubjectVH(view);
            }
        });
    }
}
