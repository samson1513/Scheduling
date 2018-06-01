package com.am.scheduling.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.am.scheduling.data.database.models.Group;

import java.util.List;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Dao
public interface GroupDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Group... entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Group> entity);

    @Delete
    void delete(Group entity);

    @Update
    void update(Group entity);

    @Query("SELECT * FROM groups")
    List<Group> get();

    @Query("SELECT * FROM groups " +
            "WHERE id = :id")
    Group get(int id);
}
