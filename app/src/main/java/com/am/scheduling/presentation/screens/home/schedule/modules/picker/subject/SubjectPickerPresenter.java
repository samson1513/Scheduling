package com.am.scheduling.presentation.screens.home.schedule.modules.picker.subject;


import com.am.scheduling.presentation.abc.core.base.BasePresenterImpl;
import com.am.scheduling.presentation.screens.home.management.subject.list.adapter.SubjectDH;

import io.reactivex.Observable;

/**
 * Created by Alex Michenko
 * on 31.05.2018.
 */
public class SubjectPickerPresenter extends BasePresenterImpl<SubjectPickerContract.View> implements SubjectPickerContract.Presenter {

    private SubjectPickerContract.Model model;

    public SubjectPickerPresenter(SubjectPickerContract.View view, SubjectPickerContract.Model model) {
        super(view);
        this.model = model;
    }

    @Override
    public void subscribe() {
        addDisposable(model.subjectsCase.async()
                .flatMapObservable(Observable::fromIterable)
                .map(SubjectDH::new)
                .toList()
                .subscribe(getView()::setItems, Throwable::printStackTrace));
    }

    @Override
    public void selectItem(SubjectDH dh) {
        getView().finishWithResult(dh.model);
    }
}
