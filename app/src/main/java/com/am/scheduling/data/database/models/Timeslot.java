package com.am.scheduling.data.database.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by Alex Michenko
 * on 03.03.2018.
 */

@Entity
public class Timeslot {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "schedule_id")
    private String scheduleId;
    @ColumnInfo(name = "start_time")
    private Date startTime;
    @ColumnInfo(name = "end_time")
    private Date endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
