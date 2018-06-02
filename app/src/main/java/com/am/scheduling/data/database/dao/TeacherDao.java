package com.am.scheduling.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.am.scheduling.data.database.models.Teacher;

import java.util.List;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Dao
public interface TeacherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Teacher... entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Teacher> entity);

    @Delete
    void delete(Teacher entity);

    @Update
    void update(Teacher entity);

    @Query("SELECT * FROM teachers")
    List<Teacher> get();

    @Query("SELECT COUNT(*) FROM teachers")
    int count();
}
