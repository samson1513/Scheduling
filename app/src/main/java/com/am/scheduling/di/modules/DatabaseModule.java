package com.am.scheduling.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.am.scheduling.data.database.AppDatabase;
import com.am.scheduling.data.database.dao.GroupDao;
import com.am.scheduling.data.database.dao.RoomDao;
import com.am.scheduling.data.database.dao.SubjectDao;
import com.am.scheduling.data.database.dao.TeacherDao;
import com.am.scheduling.data.database.dao.TimeslotDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */
@Singleton
@Module
public class DatabaseModule {

    @Provides
    public AppDatabase provideAppDatabase(final Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class,
                "db-scheduling")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    public RoomDao roomDao(AppDatabase database) {
        return database.roomDao();
    }

    @Provides
    public GroupDao groupDao(AppDatabase database) {
        return database.groupDao();
    }

    @Provides
    public TeacherDao teacherDao(AppDatabase database) {
        return database.teacherDao();
    }

    @Provides
    public SubjectDao subjectDao(AppDatabase database) {
        return database.subjectDao();
    }

    @Provides
    public TimeslotDao timeslotDao(AppDatabase database) {
        return database.timeslotDao();
    }

}
