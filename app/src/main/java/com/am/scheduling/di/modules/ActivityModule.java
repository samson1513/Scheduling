package com.am.scheduling.di.modules;


import com.am.scheduling.presentation.screens.main.MainActivity;
import com.am.scheduling.presentation.screens.main.MainModule;
import com.am.scheduling.presentation.screens.splash.SplashActivity;
import com.am.scheduling.presentation.screens.splash.SplashModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

@Module(includes = {
        NavigationModule.class,
        FragmentModule.class
})
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = {SplashModule.class})
    abstract SplashActivity splashActivity();

    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity mainActivity();
}
