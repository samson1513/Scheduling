package com.am.scheduling.presentation.screens.home.root.subject.create;

import com.am.scheduling.domain.usecases.subject.CreateSubjectCase;
import com.am.scheduling.presentation.abc.core.base.BasePresenter;
import com.am.scheduling.presentation.abc.core.base.BaseView;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public interface CreateSubjectContract {

    interface View extends BaseView {
        void finish();
    }

    interface Presenter extends BasePresenter {
        void save(String name);
    }

    class Model {

        @Inject
        CreateSubjectCase mCreateCase;

        @Inject
        public Model() {
        }
    }

    @Module
    class CreateSubjectModule {

        @Provides
        protected View provideView(CreateSubjectFragment fragment) {
            return fragment;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model) {
            return new CreateSubjectPresenter(view, model);
        }
    }

}