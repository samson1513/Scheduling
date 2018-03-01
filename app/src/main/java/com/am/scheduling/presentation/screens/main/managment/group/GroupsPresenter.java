package com.am.scheduling.presentation.screens.main.managment.group;

import com.am.scheduling.domain.base.single.DefaultSingleObserver;
import com.am.scheduling.domain.usecases.group.GroupListCase;
import com.am.scheduling.presentation.core.list.ListPresenterImpl;
import com.am.scheduling.presentation.screens.main.managment.group.adapter.GroupDH;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class GroupsPresenter extends ListPresenterImpl<GroupsContract.View>
        implements GroupsContract.Presenter {

    private GroupListCase mGroupListCase;

    @Inject
    public GroupsPresenter(GroupListCase groupListCase) {
        mGroupListCase = groupListCase;
    }

    @Override
    public void loadData() {
        addDisposable(mGroupListCase.execute(new ListObserver()));
    }

    @Override
    public void createGroup() {
        getView().startCreateGroupScreen();
    }

    class ListObserver extends DefaultSingleObserver<List<GroupDH>> {

        @Override
        public void onSuccess(List<GroupDH> groupDHS) {
            getView().setItems(groupDHS);
        }
    }
}
