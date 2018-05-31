package com.am.scheduling.data.database.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Alex Michenko
 * on 01.03.2018.
 */

@Entity(tableName = "groups")
public class Group {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public int size;

    public Group() {
    }

    @Ignore
    public Group(String name, int size) {
        this.name = name;
        this.size = size;
    }
}
