package com.am.scheduling.presentation.screens.home.management.room.create;

import com.am.scheduling.domain.usecases.room.CreateRoomCase;
import com.am.scheduling.presentation.abc.core.base.BasePresenter;
import com.am.scheduling.presentation.abc.core.base.BaseView;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public interface CreateRoomContract {

    interface View extends BaseView {
        void finish();
    }

    interface Presenter extends BasePresenter {
        void save(String name, String capacity);
    }

    class Model {

        @Inject
        CreateRoomCase mCreateRoomCase;

        @Inject
        public Model() {
        }
    }

    @Module
    class CreateRoomModule {

        @Provides
        protected View provideView(CreateRoomFragment fragment) {
            return fragment;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model) {
            return new CreateRoomPresenter(view, model);
        }
    }

}