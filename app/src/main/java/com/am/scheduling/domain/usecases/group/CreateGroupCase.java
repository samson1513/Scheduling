package com.am.scheduling.domain.usecases.group;

import com.am.scheduling.data.database.models.Group;
import com.am.scheduling.domain.base.input.CompletableCase;
import com.am.scheduling.domain.repositories.group.GroupRepo;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CreateGroupCase extends CompletableCase<Group> {

    @Inject
    GroupRepo repo;

    @Inject
    public CreateGroupCase() {
    }

    @Override
    protected Completable buildTask(Group data) {
        return repo.save(data);
    }
}
