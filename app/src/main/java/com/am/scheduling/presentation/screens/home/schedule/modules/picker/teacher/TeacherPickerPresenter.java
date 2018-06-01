package com.am.scheduling.presentation.screens.home.schedule.modules.picker.teacher;


import com.am.scheduling.presentation.abc.core.base.BasePresenterImpl;
import com.am.scheduling.presentation.screens.home.management.teacher.list.adapter.TeacherDH;

import io.reactivex.Observable;

/**
 * Created by Alex Michenko
 * on 31.05.2018.
 */
public class TeacherPickerPresenter extends BasePresenterImpl<TeacherPickerContract.View> implements TeacherPickerContract.Presenter {

    private TeacherPickerContract.Model model;

    public TeacherPickerPresenter(TeacherPickerContract.View view, TeacherPickerContract.Model model) {
        super(view);
        this.model = model;
    }

    @Override
    public void subscribe() {
        addDisposable(model.teachersCase.async()
                .flatMapObservable(Observable::fromIterable)
                .map(TeacherDH::new)
                .toList()
                .subscribe(getView()::setItems, Throwable::printStackTrace));
    }

    @Override
    public void selectItem(TeacherDH dh) {
        getView().finishWithResult(dh.model);
    }
}
