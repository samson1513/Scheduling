package com.am.scheduling.presentation.screens.home.schedule.modules;

import android.os.Bundle;

import com.am.scheduling.chapter5.Timetable;
import com.am.scheduling.data.database.models.Group;
import com.am.scheduling.domain.usecases.subject.SubjectListCase;
import com.am.scheduling.presentation.abc.core.base.BasePresenter;
import com.am.scheduling.presentation.abc.core.content.ContentView;
import com.am.scheduling.presentation.screens.home.schedule.modules.adapter.group_module.GroupModulesDH;
import com.am.scheduling.presentation.utils.Consts;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public interface ModulesContract {

    interface View extends ContentView {
        void setTabs(List<GroupModulesDH> items);
        void selectTab(int position);

        void startGeneratorScreen(Timetable timetable);
    }

    interface Presenter extends BasePresenter {
        void next(GroupModulesDH dh, int position);
    }

    class Model {

        @Inject
        SubjectListCase subjectListCase;

        @Inject
        public Model() {
        }
    }

    @Module
    class ModulesModule {

        @Provides
        protected View provideView(ModulesFragment fragment) {
            return fragment;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model, Bundle args) {
            ArrayList<Group> groups = args.getParcelableArrayList(Consts.KEY_LIST);
            return new ModulesPresenter(view, model, groups);
        }

        @Provides
        protected Bundle provideArguments(ModulesFragment fragment) {
            return fragment.getArguments();
        }
    }

}