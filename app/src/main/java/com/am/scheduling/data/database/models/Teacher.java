package com.am.scheduling.data.database.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Alex Michenko
 * on 02.03.2018.
 */

@Entity(tableName = "teachers")
public class Teacher {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "full_name")
    public String fullName;

    public Teacher() {
    }

    @Ignore
    public Teacher(String fullName) {
        this.fullName = fullName;
    }
}
