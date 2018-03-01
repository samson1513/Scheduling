package com.am.scheduling.data.database.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Alex Michenko
 * on 01.03.2018.
 */

@Entity(tableName = "groups")
public class Group {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
