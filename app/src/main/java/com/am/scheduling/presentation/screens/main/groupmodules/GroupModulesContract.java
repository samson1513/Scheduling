package com.am.scheduling.presentation.screens.main.groupmodules;

import com.am.scheduling.domain.usecases.group.GroupListCase;
import com.am.scheduling.domain.usecases.subject.SubjectListCase;
import com.am.scheduling.domain.usecases.teacher.TeacherListCase;
import com.am.scheduling.presentation.abc.core.base.BasePresenter;
import com.am.scheduling.presentation.abc.core.base.BaseView;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public interface GroupModulesContract {

    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter {

    }

    class Model {

        @Inject
        GroupListCase groupsCase;
        @Inject
        TeacherListCase teachersCase;
        @Inject
        SubjectListCase subjectsCase;

        @Inject
        public Model() {
        }
    }

    @Module
    class GroupModulesModule {

        @Provides
        protected View provideView(GroupModulesFragment fragment) {
            return fragment;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model) {
            return new GroupModulesPresenter(view, model);
        }
    }

}