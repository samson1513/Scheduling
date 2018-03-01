package com.am.scheduling.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.am.scheduling.data.database.AppDatabase;
import com.am.scheduling.data.database.dao.GroupDao;
import com.am.scheduling.data.database.dao.RoomDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Module
public class DatabaseModule {

    @Singleton
    @Provides
    public AppDatabase provideAppDatabase(final Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class,
                "db-scheduling")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Singleton
    @Provides
    public RoomDao roomDao(AppDatabase database) {
        return database.roomDao();
    }

    @Singleton
    @Provides
    public GroupDao groupDao(AppDatabase database) {
        return database.groupDao();
    }

}
