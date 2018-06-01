package com.am.scheduling.presentation.screens.home.schedule.modules.picker.subject;

import com.am.scheduling.data.database.models.Subject;
import com.am.scheduling.domain.usecases.subject.SubjectListCase;
import com.am.scheduling.presentation.abc.core.base.BasePresenter;
import com.am.scheduling.presentation.abc.core.base.BaseView;
import com.am.scheduling.presentation.screens.home.management.subject.list.adapter.SubjectDH;

import java.util.List;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alex Michenko
 * on 31.05.2018.
 */
public interface SubjectPickerContract {

    interface View extends BaseView {
        void setItems(List<SubjectDH> items);
        void finishWithResult(Subject subject);
    }

    interface Presenter extends BasePresenter {
        void selectItem(SubjectDH dh);
    }

    class Model {

        @Inject
        SubjectListCase subjectsCase;

        @Inject
        public Model() {
        }
    }

    @Module
    class SubjectPickerModule {

        @Provides
        protected View provideView(SubjectPickerDialog fragment) {
            return fragment;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model) {
            return new SubjectPickerPresenter(view, model);
        }
    }
}
