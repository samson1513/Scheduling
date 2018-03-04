package com.am.scheduling.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.am.scheduling.data.database.models.Timeslot;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Dao
public interface TimeslotDao {

    @Insert
    List<Long> insert(Timeslot... timeslots);

    @Delete
    int delete(Timeslot timeslot);

    @Update
    int update(Timeslot timeslot);

    @Query("SELECT * FROM timeslot")
    Single<List<Timeslot>> get();
}
