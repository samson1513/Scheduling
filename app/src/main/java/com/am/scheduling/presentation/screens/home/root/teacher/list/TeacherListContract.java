package com.am.scheduling.presentation.screens.home.root.teacher.list;

import com.am.scheduling.domain.usecases.teacher.TeacherListCase;
import com.am.scheduling.presentation.abc.core.list.ListPresenter;
import com.am.scheduling.presentation.abc.core.list.ListView;
import com.am.scheduling.presentation.screens.home.root.teacher.list.adapter.TeacherDH;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public interface TeacherListContract {

    interface View extends ListView<TeacherDH> {
        void startCreateScreen();
    }

    interface Presenter extends ListPresenter {
        void create();
    }

    class Model {

        @Inject
        TeacherListCase mCase;

        @Inject
        public Model() {
        }
    }

    @Module
    class TeacherListModule {

        @Provides
        protected View provideView(TeacherListFragment fragment) {
            return fragment;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model) {
            return new TeacherListPresenter(view, model);
        }
    }

}