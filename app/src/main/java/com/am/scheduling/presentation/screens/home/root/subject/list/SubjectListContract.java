package com.am.scheduling.presentation.screens.home.root.subject.list;

import com.am.scheduling.domain.usecases.subject.SubjectListCase;
import com.am.scheduling.presentation.abc.core.list.ListPresenter;
import com.am.scheduling.presentation.abc.core.list.ListView;
import com.am.scheduling.presentation.screens.home.root.subject.list.adapter.SubjectDH;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public interface SubjectListContract {

    interface View extends ListView<SubjectDH> {
        void startCreateScreen();
    }

    interface Presenter extends ListPresenter {
        void create();
    }

    class Model {

        @Inject
        SubjectListCase mCase;

        @Inject
        public Model() {
        }
    }

    @Module
    class SubjectListModule {

        @Provides
        protected View provideView(SubjectListFragment fragment) {
            return fragment;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model) {
            return new SubjectListPresenter(view, model);
        }
    }

}