package com.am.scheduling.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.am.scheduling.data.database.models.Subject;

import java.util.List;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Dao
public interface SubjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Subject... entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Subject> entity);

    @Delete
    void delete(Subject entity);

    @Update
    void update(Subject entity);

    @Query("SELECT * FROM subjects")
    List<Subject> get();
}
