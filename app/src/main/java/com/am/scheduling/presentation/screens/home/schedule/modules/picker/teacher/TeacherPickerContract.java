package com.am.scheduling.presentation.screens.home.schedule.modules.picker.teacher;

import com.am.scheduling.data.database.models.Teacher;
import com.am.scheduling.domain.usecases.teacher.TeacherListCase;
import com.am.scheduling.presentation.abc.core.base.BasePresenter;
import com.am.scheduling.presentation.abc.core.base.BaseView;
import com.am.scheduling.presentation.screens.home.management.teacher.list.adapter.TeacherDH;

import java.util.List;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alex Michenko
 * on 31.05.2018.
 */
public interface TeacherPickerContract {

    interface View extends BaseView {
        void setItems(List<TeacherDH> items);
        void finishWithResult(Teacher teacher);
    }

    interface Presenter extends BasePresenter {
        void selectItem(TeacherDH dh);
    }

    class Model {

        @Inject
        TeacherListCase teachersCase;

        @Inject
        public Model() {
        }
    }

    @Module
    class TeacherPickerModule {

        @Provides
        protected View provideView(TeacherPickerDialog fragment) {
            return fragment;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model) {
            return new TeacherPickerPresenter(view, model);
        }
    }
}
