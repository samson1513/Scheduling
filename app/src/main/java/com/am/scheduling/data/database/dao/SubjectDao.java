package com.am.scheduling.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.am.scheduling.data.database.models.Subject;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Dao
public interface SubjectDao {

    @Insert
    List<Long> insert(Subject... subjects);

    @Delete
    int delete(Subject subject);

    @Update
    int update(Subject subject);

    @Query("SELECT * FROM subject")
    Single<List<Subject>> get();
}
