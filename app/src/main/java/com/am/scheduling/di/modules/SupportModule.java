package com.am.scheduling.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.am.scheduling.data.database.AppDatabase;
import com.am.scheduling.presentation.utils.ResourceManager;
import com.am.scheduling.presentation.utils.authentication.AuthHelper;
import com.am.scheduling.presentation.utils.authentication.AuthHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

@Module
public class SupportModule {

    @Singleton
    @Provides
    public AuthHelper provideAuthHelper(final Context context) {
        return new AuthHelperImpl(context);
    }

//    @Singleton
//    @Provides
//    public ResourceManager provideResourceManager(final Context context) {
//        return new ResourceManager(context);
//    }
}
