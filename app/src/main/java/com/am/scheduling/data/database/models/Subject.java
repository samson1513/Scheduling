package com.am.scheduling.data.database.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Alex Michenko
 * on 03.03.2018.
 */

@Entity(tableName = "subjects")
public class Subject {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;

    public Subject() {
    }

    @Ignore
    public Subject(String name) {
        this.name = name;
    }
}
