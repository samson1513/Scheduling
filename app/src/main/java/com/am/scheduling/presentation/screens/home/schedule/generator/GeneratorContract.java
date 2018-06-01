package com.am.scheduling.presentation.screens.home.schedule.generator;

import android.os.Bundle;

import com.am.scheduling.chapter5.Timetable;
import com.am.scheduling.domain.usecases.ga.GenerateCase;
import com.am.scheduling.presentation.abc.core.base.BasePresenter;
import com.am.scheduling.presentation.abc.core.content.ContentView;
import com.am.scheduling.presentation.utils.Consts;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public interface GeneratorContract {

    interface View extends ContentView {
        void showResult(String fileName);

        void openFile(File file);
        void startHomeScreen();
    }

    interface Presenter extends BasePresenter {
        void goToHome();
        void openFile();
        void retry();
    }

    class Model {

        @Inject
        RxPermissions rxPermissions;
        @Inject
        GenerateCase generateCase;

        @Inject
        public Model() {
        }
    }

    @Module
    class GeneratorModule {

        @Provides
        protected View provideView(GeneratorFragment fragment) {
            return fragment;
        }

        @Provides
        protected Presenter providePresenter(View view, Model model, Bundle args) {
            Timetable timetable = args.getParcelable(Consts.KEY_RESULT);
            return new GeneratorPresenter(view, model, timetable);
        }

        @Provides
        protected Bundle provideArgs(GeneratorFragment fragment) {
            return fragment.getArguments();
        }

        @Provides
        protected RxPermissions provideRxPermissions(GeneratorFragment fragment) {
            return new RxPermissions(fragment.getActivity());
        }
    }

}