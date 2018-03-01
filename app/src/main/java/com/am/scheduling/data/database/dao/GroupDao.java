package com.am.scheduling.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.am.scheduling.data.database.models.Group;
import com.am.scheduling.data.database.models.Room;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Dao
public interface GroupDao {

    @Insert
    List<Long> insert(Group... groups);

    @Delete
    int delete(Group group);

    @Update
    int update(Group group);

    @Query("SELECT * FROM groups")
    Single<List<Group>> getRooms();

    @Query("SELECT * FROM groups WHERE id LIKE :id")
    Single<Group> getRoomById(String id);
}
