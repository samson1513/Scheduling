package com.am.scheduling.presentation.screens.main.managment.group;

import com.am.scheduling.presentation.core.list.ListPresenter;
import com.am.scheduling.presentation.core.list.ListView;
import com.am.scheduling.presentation.screens.main.managment.group.adapter.GroupDH;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public interface GroupsContract {

    interface View extends ListView<GroupDH, Presenter> {
        void startCreateGroupScreen();
    }

    interface Presenter extends ListPresenter<View> {
        void createGroup();
    }
}
