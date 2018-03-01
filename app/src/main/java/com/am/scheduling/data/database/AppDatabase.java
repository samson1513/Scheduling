package com.am.scheduling.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.am.scheduling.data.database.dao.GroupDao;
import com.am.scheduling.data.database.dao.RoomDao;
import com.am.scheduling.data.database.models.Group;
import com.am.scheduling.data.database.models.Room;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */
@Database(entities = {Room.class,
        Group.class},
        version = 1,
        exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract RoomDao roomDao();
    public abstract GroupDao groupDao();
}
