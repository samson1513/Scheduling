package com.am.scheduling.presentation.screens.home.root.room.list;

import com.am.scheduling.presentation.abc.core.list.ListPresenterImpl;
import com.am.scheduling.presentation.screens.home.root.room.list.adapter.RoomDH;

import io.reactivex.Observable;

public class RoomListPresenter extends ListPresenterImpl<RoomListContract.View> implements RoomListContract.Presenter {

    private RoomListContract.Model model;

    public RoomListPresenter(RoomListContract.View view, RoomListContract.Model model) {
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
                .map(RoomDH::new)
                .toList()
                .subscribe(getView()::setItems, Throwable::printStackTrace));
    }

    @Override
    public void create() {
        getView().startCreateScreen();
    }
}