package com.am.scheduling.presentation.screens.main.managment.schedule.create;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Module
public abstract class CreateScheduleModule {

    @Binds
    abstract CreateScheduleContract.Presenter presenter(CreateSchedulePresenter presenter);
}
