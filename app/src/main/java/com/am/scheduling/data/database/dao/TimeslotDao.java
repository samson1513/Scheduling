package com.am.scheduling.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.am.scheduling.data.database.models.Timeslot;

import java.util.List;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Dao
public interface TimeslotDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Timeslot... entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Timeslot> entity);

    @Delete
    void delete(Timeslot entity);

    @Update
    void update(Timeslot entity);

    @Query("SELECT * FROM timeslots")
    List<Timeslot> get();
}
