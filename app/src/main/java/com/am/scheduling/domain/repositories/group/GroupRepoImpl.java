package com.am.scheduling.domain.repositories.group;

import com.am.scheduling.data.database.dao.GroupDao;
import com.am.scheduling.data.database.models.Group;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class GroupRepoImpl implements GroupRepo {

    @Inject
    GroupDao mGroupDao;

    @Inject
    public GroupRepoImpl() {
    }

    @Override
    public Single<List<Group>> getGroups() {
        return Single.just(mGroupDao.get());
    }

    @Override
    public Completable save(Group group) {
        return Completable.fromAction(() -> mGroupDao.insert(group));
    }
}
