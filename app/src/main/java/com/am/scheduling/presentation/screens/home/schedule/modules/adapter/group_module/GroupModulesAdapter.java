package com.am.scheduling.presentation.screens.home.schedule.modules.adapter.group_module;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.list.pager.ListPagerAdapter;
import com.am.scheduling.presentation.abc.core.list.pager.PagerVH;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 01.06.2018.
 */
public class GroupModulesAdapter extends ListPagerAdapter<GroupModulesDH> {


    @Inject
    public GroupModulesAdapter() {
    }

    @Override
    protected PagerVH<GroupModulesDH> onCreateViewHolder(LayoutInflater inflater, @NonNull ViewGroup container, int viewType) {
        return new GroupModulesVH(inflater.inflate(R.layout.item_group_modules, container, false));
    }

    public void updateItem(GroupModulesDH item, int position) {
        getItems().set(position, item);
        notifyDataSetChanged();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return getItem(position).group.name;
    }
}
