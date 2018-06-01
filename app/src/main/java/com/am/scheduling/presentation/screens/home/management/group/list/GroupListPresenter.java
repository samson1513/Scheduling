package com.am.scheduling.presentation.screens.home.management.group.list;

import com.am.scheduling.presentation.abc.core.list.ListPresenterImpl;
import com.am.scheduling.presentation.screens.home.management.group.list.adapter.GroupDH;

import io.reactivex.Observable;

public class GroupListPresenter extends ListPresenterImpl<GroupListContract.View> implements GroupListContract.Presenter {

    private GroupListContract.Model model;

    public GroupListPresenter(GroupListContract.View view, GroupListContract.Model model) {
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
                .map(GroupDH::new)
                .toList()
                .subscribe(getView()::setItems, Throwable::printStackTrace)
        );
    }

    @Override
    public void create() {
        getView().startCreateScreen();
    }
}