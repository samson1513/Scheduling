package com.am.scheduling.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.am.scheduling.data.database.dao.GroupDao;
import com.am.scheduling.data.database.dao.RoomDao;
import com.am.scheduling.data.database.dao.SubjectDao;
import com.am.scheduling.data.database.dao.TeacherDao;
import com.am.scheduling.data.database.dao.TimeslotDao;
import com.am.scheduling.data.database.models.Group;
import com.am.scheduling.data.database.models.Room;
import com.am.scheduling.data.database.models.Subject;
import com.am.scheduling.data.database.models.Teacher;
import com.am.scheduling.data.database.models.Timeslot;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */
@Database(entities = {Room.class,
        Group.class,
        Subject.class,
        Timeslot.class,
        Teacher.class},
        version = 1,
        exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract RoomDao roomDao();
    public abstract GroupDao groupDao();
    public abstract TeacherDao teacherDao();
    public abstract SubjectDao subjectDao();
    public abstract TimeslotDao timeslotDao();
}
