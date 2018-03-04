package com.am.scheduling.domain.repositories.timeslot;

import com.am.scheduling.data.database.models.Timeslot;
import com.am.scheduling.presentation.screens.main.managment.schedule.adapter.ScheduleDH;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class TimeslotMapper {

    @Inject
    public TimeslotMapper() {
    }

    public ScheduleDH convert(List<Timeslot> models) {
        Timeslot start = models.get(0);
        Timeslot end = models.get(models.size() - 1);
        return new ScheduleDH(start.getStartTime(), end.getEndTime());
    }
}
