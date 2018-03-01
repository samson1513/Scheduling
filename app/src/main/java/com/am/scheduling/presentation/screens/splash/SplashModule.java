package com.am.scheduling.presentation.screens.splash;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Module
public interface SplashModule {

    @Binds
    SplashContract.Presenter presenter(SplashPresenter presenter);
}
