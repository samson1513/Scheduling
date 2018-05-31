package com.am.scheduling.presentation.screens.home.root.teacher.list;

import com.am.scheduling.presentation.abc.core.list.ListPresenterImpl;
import com.am.scheduling.presentation.screens.home.root.teacher.list.adapter.TeacherDH;

import io.reactivex.Observable;

public class TeacherListPresenter extends ListPresenterImpl<TeacherListContract.View> implements TeacherListContract.Presenter {

    private TeacherListContract.Model model;

    public TeacherListPresenter(TeacherListContract.View view, TeacherListContract.Model model) {
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
                .map(TeacherDH::new)
                .toList()
                .subscribe(getView()::setItems, Throwable::printStackTrace));
    }

    @Override
    public void create() {
        getView().startCreateScreen();
    }
}