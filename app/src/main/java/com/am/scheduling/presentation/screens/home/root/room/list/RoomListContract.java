package com.am.scheduling.presentation.screens.home.root.room.list;

import com.am.scheduling.domain.usecases.room.RoomListCase;
import com.am.scheduling.presentation.abc.core.list.ListPresenter;
import com.am.scheduling.presentation.abc.core.list.ListView;
import com.am.scheduling.presentation.screens.home.root.room.list.adapter.RoomDH;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public interface RoomListContract {

    interface View extends ListView<RoomDH> {
        void startCreateScreen();
    }

    interface Presenter extends ListPresenter {
        void create();
    }

    class Model {

        @Inject
        RoomListCase mCase;

        @Inject
        public Model() {
        }
    }

    @Module
    class RoomListModule {

        @Provides
        protected View provideView(RoomListFragment fragment) {
            return fragment;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model) {
            return new RoomListPresenter(view, model);
        }
    }

}