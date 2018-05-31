package com.am.scheduling.presentation.screens.home.root.group.list;

import com.am.scheduling.domain.usecases.group.GroupListCase;
import com.am.scheduling.presentation.abc.core.list.ListPresenter;
import com.am.scheduling.presentation.abc.core.list.ListView;
import com.am.scheduling.presentation.screens.home.root.group.list.adapter.GroupDH;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public interface GroupListContract {

    interface View extends ListView<GroupDH> {
        void startCreateScreen();
    }

    interface Presenter extends ListPresenter {
        void create();
    }

    class Model {

        @Inject
        GroupListCase mCase;

        @Inject
        public Model() {
        }
    }

    @Module
    class GroupListModule {

        @Provides
        protected View provideView(GroupListFragment fragment) {
            return fragment;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model) {
            return new GroupListPresenter(view, model);
        }
    }

}