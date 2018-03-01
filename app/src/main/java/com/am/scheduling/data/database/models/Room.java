package com.am.scheduling.data.database.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Entity
public class Room {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int capacity;

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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
