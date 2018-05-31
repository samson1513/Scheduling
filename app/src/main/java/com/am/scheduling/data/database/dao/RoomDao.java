package com.am.scheduling.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.am.scheduling.data.database.models.Room;

import java.util.List;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Dao
public interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Room... entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Room> entity);

    @Delete
    void delete(Room entity);

    @Update
    void update(Room entity);

    @Query("SELECT * FROM rooms")
    List<Room> get();
}
