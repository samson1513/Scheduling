package com.am.scheduling.data.database.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by Alex Michenko
 * on 03.03.2018.
 */

@Entity(tableName = "timeslots")
public class Timeslot {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "start_time")
    public Date startTime;
    @ColumnInfo(name = "end_time")
    public Date endTime;

    public Timeslot() {
    }

    @Ignore
    public Timeslot(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
