package com.am.scheduling.di.components;


import com.am.scheduling.di.modules.ActivityModule;
import com.am.scheduling.di.modules.ApplicationModule;
import com.am.scheduling.presentation.App;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        ActivityModule.class
})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
}
