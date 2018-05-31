package com.am.scheduling.di.modules;


import com.am.scheduling.presentation.screens.home.HomeActivity;
import com.am.scheduling.presentation.screens.home.HomeContract;
import com.am.scheduling.presentation.screens.splash.SplashActivity;
import com.am.scheduling.presentation.screens.splash.SplashContract;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

@Module(includes = {
        FragmentModule.class
})
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = {HomeContract.HomeModule.class})
    abstract HomeActivity homeActivity();

    @ContributesAndroidInjector(modules = {SplashContract.SplashModule.class})
    abstract SplashActivity splashActivity();
}
