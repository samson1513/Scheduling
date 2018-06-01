package com.am.scheduling.presentation.screens.home.management.group.create;

import com.am.scheduling.domain.usecases.group.CreateGroupCase;
import com.am.scheduling.presentation.abc.core.base.BasePresenter;
import com.am.scheduling.presentation.abc.core.base.BaseView;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public interface CreateGroupContract {

    interface View extends BaseView {

        void finish();
    }

    interface Presenter extends BasePresenter {

        void save(String name, String capacity);
    }

    class Model {

        @Inject
        CreateGroupCase mCreateCase;

        @Inject
        public Model() {
        }
    }

    @Module
    class CreateGroupModule {

        @Provides
        protected View provideView(CreateGroupFragment fragment) {
            return fragment;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model) {
            return new CreateGroupPresenter(view, model);
        }
    }

}