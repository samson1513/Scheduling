package com.am.scheduling.presentation.screens.main.managment.schedule;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */
@Module
public abstract class SchedulesModule {

    @Binds
    abstract SchedulesContract.Presenter presenter(SchedulesPresenter presenter);

}
