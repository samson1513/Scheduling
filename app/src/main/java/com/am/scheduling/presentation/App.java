package com.am.scheduling.presentation;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.am.scheduling.Config;
import com.am.scheduling.di.components.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public class App extends DaggerApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    @Override
    public void onCreate() {
        super.onCreate();

        Config.init(this);
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }
}
