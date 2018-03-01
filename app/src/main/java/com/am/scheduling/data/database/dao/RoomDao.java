package com.am.scheduling.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.am.scheduling.data.database.models.Room;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Dao
public interface RoomDao {

    @Insert
    List<Long> insert(Room... rooms);

    @Delete
    int delete(Room room);

    @Update
    int update(Room room);

    @Query("SELECT * FROM room")
    Single<List<Room>> getRooms();

    @Query("SELECT * FROM room WHERE id LIKE :id")
    Single<Room> getRoomById(String id);
}
