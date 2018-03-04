package com.am.scheduling.presentation.screens.main.managment.schedule.create.adapter.slot;

import com.am.scheduling.presentation.utils.DateUtil;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.Calendar;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class SlotDH implements MultiItemEntity {

    private Calendar startTime;
    private Calendar endTime;

    public SlotDH() {

    }

    @Override
    public int getItemType() {
        return 0;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }


    public String getStartTimeFormatted() {
        if (startTime == null)
            return null;
        else
            return DateUtil.toString(startTime.getTime(), DateUtil.PATTERN_TIME);
    }

    public String getEndTimeFormatted() {
        if (endTime == null)
            return null;
        else
            return DateUtil.toString(endTime.getTime(), DateUtil.PATTERN_TIME);
    }
}
