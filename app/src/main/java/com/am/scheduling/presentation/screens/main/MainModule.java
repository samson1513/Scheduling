package com.am.scheduling.presentation.screens.main;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */
@Module
public interface MainModule {

    @Binds
    MainContract.Presenter presenter(MainPresenter presenter);
}
