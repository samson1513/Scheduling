package com.am.scheduling.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.am.scheduling.data.database.models.Teacher;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Dao
public interface TeacherDao {

    @Insert
    List<Long> insert(Teacher... groups);

    @Delete
    int delete(Teacher group);

    @Update
    int update(Teacher group);

    @Query("SELECT * FROM teacher")
    Single<List<Teacher>> get();
}
