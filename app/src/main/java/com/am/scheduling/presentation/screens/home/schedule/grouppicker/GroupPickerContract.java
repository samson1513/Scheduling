package com.am.scheduling.presentation.screens.home.schedule.grouppicker;

import com.am.scheduling.data.database.models.Group;
import com.am.scheduling.domain.usecases.group.GroupListCase;
import com.am.scheduling.presentation.abc.core.list.ListPresenter;
import com.am.scheduling.presentation.abc.core.list.ListView;
import com.am.scheduling.presentation.screens.home.schedule.grouppicker.adapter.CheckGroupDH;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public interface GroupPickerContract {

    interface View extends ListView<CheckGroupDH> {
        void startModulesScreen(ArrayList<Group> checkedGroups);
    }

    interface Presenter extends ListPresenter {
        void check(CheckGroupDH dh, int position);
        void next();
    }

    class Model {

        @Inject
        GroupListCase mCase;

        @Inject
        public Model() {
        }
    }

    @Module
    class GroupPickerModule {

        @Provides
        protected View provideView(GroupPickerFragment fragment) {
            return fragment;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model) {
            return new GroupPickerPresenter(view, model);
        }
    }

}