package com.am.scheduling.domain.repositories.group;

import com.am.scheduling.data.database.dao.GroupDao;
import com.am.scheduling.data.database.models.Group;
import com.am.scheduling.domain.repositories.group.mapper.GroupMapper;
import com.am.scheduling.presentation.screens.main.managment.group.adapter.GroupDH;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class GroupRepoImpl implements GroupRepo {

    private GroupDao mGroupDao;
    private GroupMapper mGroupMapper;

    @Inject
    public GroupRepoImpl(GroupDao roomDao, GroupMapper groupMapper) {
        mGroupDao = roomDao;
        mGroupMapper = groupMapper;
    }

    @Override
    public Single<List<GroupDH>> getGroups() {
        return mGroupDao.get()
                .flatMapObservable(Observable::fromIterable)
                .map(mGroupMapper::convert)
                .toList();
    }

    @Override
    public Completable save(Group group) {
        return Completable.fromCallable(() -> mGroupDao.insert(group));
    }
}
