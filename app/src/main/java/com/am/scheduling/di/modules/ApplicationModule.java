package com.am.scheduling.di.modules;

import android.app.Application;
import android.content.Context;

import com.am.scheduling.data.database.AppDatabase;
import com.am.scheduling.presentation.App;
import com.am.scheduling.presentation.utils.ResourceManager;
import com.am.scheduling.presentation.utils.authentication.AuthHelper;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

@Module(includes = {
        NetworkModule.class,
        RepositoryModule.class,
        SupportModule.class,
        DatabaseModule.class
})
public abstract class ApplicationModule {

    @Binds
    abstract Context context(final App app);

    @Binds
    abstract Application application(final App app);

    @Binds
    abstract ResourceManager provideResourceManager(ResourceManager resourceManager);

//    abstract AuthHelper authHelper();
//
//    abstract AppDatabase appDatabase();
}
