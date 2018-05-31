package com.am.scheduling.presentation.screens.home.root.timeslot.list;

import com.am.scheduling.presentation.abc.core.list.ListPresenterImpl;
import com.am.scheduling.presentation.screens.home.root.timeslot.list.adapter.TimeslotDH;

import io.reactivex.Observable;

public class TimeslotListPresenter extends ListPresenterImpl<TimeslotListContract.View> implements TimeslotListContract.Presenter {

    private TimeslotListContract.Model model;

    public TimeslotListPresenter(TimeslotListContract.View view, TimeslotListContract.Model model) {
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
                .map(TimeslotDH::new)
                .toList()
                .subscribe(getView()::setItems, Throwable::printStackTrace));
    }

    @Override
    public void create() {
        getView().startCreateScreen();
    }
}