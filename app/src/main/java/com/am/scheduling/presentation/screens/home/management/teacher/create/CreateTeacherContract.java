package com.am.scheduling.presentation.screens.home.management.teacher.create;

import com.am.scheduling.domain.usecases.teacher.CreateTeacherCase;
import com.am.scheduling.presentation.abc.core.base.BasePresenter;
import com.am.scheduling.presentation.abc.core.base.BaseView;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public interface CreateTeacherContract {

    interface View extends BaseView {
        void finish();
    }

    interface Presenter extends BasePresenter {
        void save(String first, String last);
    }

    class Model {

        @Inject
        CreateTeacherCase mCreateCase;

        @Inject
        public Model() {
        }
    }

    @Module
    class CreateTeacherModule {

        @Provides
        protected View provideView(CreateTeacherFragment fragment) {
            return fragment;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model) {
            return new CreateTeacherPresenter(view, model);
        }
    }

}