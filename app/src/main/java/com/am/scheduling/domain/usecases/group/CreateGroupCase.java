package com.am.scheduling.domain.usecases.group;

import com.am.scheduling.data.database.models.Group;
import com.am.scheduling.data.database.models.Room;
import com.am.scheduling.domain.base.completable.CompletableAsyncUseCase;
import com.am.scheduling.domain.repositories.group.GroupRepo;
import com.am.scheduling.domain.repositories.room.RoomRepo;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CreateGroupCase extends CompletableAsyncUseCase {

    @Inject
    GroupRepo mGroupRepo;
    private Group mGroup;

    @Inject
    public CreateGroupCase() {
    }

    public CreateGroupCase with(String name, int size) {
        mGroup = new Group();
        mGroup.setName(name);
        mGroup.setSize(size);
        return this;
    }

    @Override
    protected Completable buildTask() {
        return mGroupRepo.save(mGroup);
    }
}
