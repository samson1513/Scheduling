package com.am.scheduling.presentation.screens.home.management.subject.list;

import com.am.scheduling.presentation.abc.core.list.ListPresenterImpl;
import com.am.scheduling.presentation.screens.home.management.subject.list.adapter.SubjectDH;

import io.reactivex.Observable;

public class SubjectListPresenter extends ListPresenterImpl<SubjectListContract.View> implements SubjectListContract.Presenter {

    private SubjectListContract.Model model;

    public SubjectListPresenter(SubjectListContract.View view, SubjectListContract.Model model) {
        super(view);
        this.model = model;
    }

    @Override
    public void loadMore() {

    }

    @Override
    public void subscribe() {
        addDisposable(model.mCase.async()
                .flatMapObservable(Observable::fromIterable)
                .map(SubjectDH::new)
                .toList()
                .subscribe(getView()::setItems, Throwable::printStackTrace));
    }

    @Override
    public void create() {
        getView().startCreateScreen();
    }
}