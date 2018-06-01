package com.am.scheduling.presentation.screens.home.management.timeslot.create.adapter.day;

import com.am.scheduling.presentation.utils.DateUtil;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.Calendar;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class DayDH implements MultiItemEntity {

    private Calendar day;
    private boolean isSelected;

    public DayDH(int day) {
        this.day = Calendar.getInstance();
        this.day.set(Calendar.DAY_OF_YEAR, day);
    }

    @Override
    public int getItemType() {
        return 0;
    }

    public Calendar getDay() {
        return day;
    }

    public String getDayName() {
        return DateUtil.toString(day.getTime(), DateUtil.PATTERN_WEEK_DAY);
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
