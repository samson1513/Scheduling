package com.am.scheduling.domain.usecases.group;

import com.am.scheduling.data.database.models.Group;
import com.am.scheduling.domain.base.no_input.NoInputSingleCase;
import com.am.scheduling.domain.repositories.group.GroupRepo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class GroupListCase extends NoInputSingleCase<List<Group>> {

    @Inject
    GroupRepo mGroupRepo;

    @Inject
    public GroupListCase() {
    }

    @Override
    protected Single<List<Group>> buildTask() {
        return mGroupRepo.getGroups();
    }
}
