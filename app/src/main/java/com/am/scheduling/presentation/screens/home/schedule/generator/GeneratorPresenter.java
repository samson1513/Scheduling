package com.am.scheduling.presentation.screens.home.schedule.generator;

import android.Manifest;

import com.am.scheduling.chapter5.Timetable;
import com.am.scheduling.presentation.abc.core.base.BasePresenterImpl;
import com.am.scheduling.presentation.abc.core.placeholder.Holder;

import java.io.File;

public class GeneratorPresenter extends BasePresenterImpl<GeneratorContract.View> implements GeneratorContract.Presenter {

    private GeneratorContract.Model model;
    private Timetable timetable;
    private File generatedFile;

    public GeneratorPresenter(GeneratorContract.View view, GeneratorContract.Model model, Timetable timetable) {
        super(view);
        this.model = model;
        this.timetable = new Timetable(timetable);
    }

    @Override
    public void subscribe() {
        if (generatedFile == null) {
            getView().showProgress();
            addDisposable(model.rxPermissions
                    .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    .filter(aBoolean -> aBoolean)
                    .firstOrError()
                    .flatMap(aBoolean -> model.generateCase.async(timetable))
                    .subscribe(file -> {
                        getView().hideProgress();
                        generatedFile = file;
                        getView().showResult(generatedFile.getName());
                    }, throwable -> {
                        throwable.printStackTrace();
                        getView().showPlaceholder(Holder.UNKNOWN);
                    })
            );
        }
    }

    @Override
    public void goToHome() {
        getView().startHomeScreen();
    }

    @Override
    public void openFile() {
        getView().openFile(generatedFile);
    }

    @Override
    public void retry() {
        generatedFile = null;
        subscribe();
    }
}