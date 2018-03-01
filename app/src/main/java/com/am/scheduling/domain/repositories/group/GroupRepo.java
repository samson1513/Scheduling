package com.am.scheduling.domain.repositories.group;

import com.am.scheduling.data.database.models.Group;
import com.am.scheduling.data.database.models.Room;
import com.am.scheduling.presentation.screens.main.managment.group.adapter.GroupDH;
import com.am.scheduling.presentation.screens.main.managment.room.adapter.RoomDH;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public interface GroupRepo {

    Single<List<GroupDH>> getGroups();

    Completable save(Group group);
}
