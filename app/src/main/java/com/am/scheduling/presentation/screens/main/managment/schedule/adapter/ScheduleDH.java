package com.am.scheduling.presentation.screens.main.managment.schedule.adapter;

import com.am.scheduling.presentation.utils.DateUtil;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.Date;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class ScheduleDH implements MultiItemEntity {

    private String days;
    private String time;

    public ScheduleDH(Date start, Date end) {
        days = String.format("%s-%s",
                DateUtil.toString(start, DateUtil.PATTERN_WEEK_DAY),
                DateUtil.toString(end, DateUtil.PATTERN_WEEK_DAY));
        time = String.format("%s-%s",
                DateUtil.toString(start, DateUtil.PATTERN_TIME),
                DateUtil.toString(end, DateUtil.PATTERN_TIME));
    }

    public String getDays() {
        return days;
    }

    public String getTime() {
        return time;
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
