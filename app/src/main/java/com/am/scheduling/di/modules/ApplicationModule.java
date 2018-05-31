package com.am.scheduling.di.modules;

import android.app.Application;
import android.content.Context;

import com.am.scheduling.presentation.App;
import com.am.scheduling.presentation.utils.ResourceManager;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

@Module(includes = {
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
}
