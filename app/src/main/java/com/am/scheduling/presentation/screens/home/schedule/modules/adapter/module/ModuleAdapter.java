package com.am.scheduling.presentation.screens.home.schedule.modules.adapter.module;

import android.view.View;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.list.adapter.BaseVH;
import com.am.scheduling.presentation.abc.core.list.adapter.DelegateVH;
import com.am.scheduling.presentation.abc.core.list.adapter.SimpleAdapter;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 31.05.2018.
 */
public class ModuleAdapter extends SimpleAdapter<ModuleDH> {


    @Inject
    public ModuleAdapter() {
    }

    @Override
    protected void initViewTypes(ViewTypeBuilder builder) {
        builder.addViewType(0, R.layout.item_module, new DelegateVH<ModuleDH>() {
            @Override
            public BaseVH<ModuleDH> createVH(View view) {
                return new ModuleVH(view);
            }
        });
    }
}
