package com.am.scheduling.domain.repositories.group;

import com.am.scheduling.data.database.models.Group;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public interface GroupRepo {

    Single<List<Group>> getGroups();

    Completable save(Group group);
}
