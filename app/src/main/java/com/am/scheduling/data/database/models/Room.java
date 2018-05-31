package com.am.scheduling.data.database.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Entity(tableName = "rooms")
public class Room {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public int capacity;

    public Room() {
    }

    @Ignore
    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}
