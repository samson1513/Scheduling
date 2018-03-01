package com.am.scheduling.domain.usecases.group;

import com.am.scheduling.domain.base.single.SingleAsyncUseCase;
import com.am.scheduling.domain.repositories.group.GroupRepo;
import com.am.scheduling.domain.repositories.room.RoomRepo;
import com.am.scheduling.presentation.screens.main.managment.group.adapter.GroupDH;
import com.am.scheduling.presentation.screens.main.managment.room.adapter.RoomDH;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class GroupListCase extends SingleAsyncUseCase<List<GroupDH>> {

    @Inject
    GroupRepo mGroupRepo;

    @Inject
    public GroupListCase() {
    }

    @Override
    protected Single<List<GroupDH>> buildTask() {
        return mGroupRepo.getGroups();
    }
}
