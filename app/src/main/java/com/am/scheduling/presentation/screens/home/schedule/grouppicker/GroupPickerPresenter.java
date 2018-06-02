package com.am.scheduling.presentation.screens.home.schedule.grouppicker;

import com.am.scheduling.data.database.models.Group;
import com.am.scheduling.presentation.abc.core.list.ListPresenterImpl;
import com.am.scheduling.presentation.screens.home.schedule.grouppicker.adapter.CheckGroupDH;

import java.util.ArrayList;

import io.reactivex.Observable;

public class GroupPickerPresenter extends ListPresenterImpl<GroupPickerContract.View> implements GroupPickerContract.Presenter {

    private GroupPickerContract.Model model;
    private ArrayList<Group> checkedGroups;

    public GroupPickerPresenter(GroupPickerContract.View view, GroupPickerContract.Model model) {
        super(view);
        this.model = model;
        checkedGroups = new ArrayList<>();
    }

    @Override
    public void loadMore() {

    }

    @Override
    public void subscribe() {
        addDisposable(model.mCase.async()
                .flatMapObservable(Observable::fromIterable)
                .map(CheckGroupDH::new)
                .map(groupDH -> {
                    groupDH.checked = getIndex(groupDH.group) != -1;
                    return groupDH;
                })
                .toList()
                .subscribe(getView()::setItems, Throwable::printStackTrace)
        );
    }

    @Override
    public void next() {
        if (!checkedGroups.isEmpty()) {
            getView().startModulesScreen(checkedGroups);
        } else {
            getView().showMessage("Select groups");
        }
    }

    @Override
    public void check(CheckGroupDH dh, int position) {
        boolean checked = !dh.checked;
        if (checked) {
            checkedGroups.add(dh.group);
        } else {
            checkedGroups.remove(getIndex(dh.group));
        }
        dh.checked = checked;
        getView().updateItem(dh, position);
    }

    private int getIndex(Group group) {
        for (int i = 0; i < checkedGroups.size(); i++) {
            if (checkedGroups.get(i).id == group.id) {
                return i;
            }
        }
        return -1;
    }
}