package com.am.scheduling.presentation.screens.main.managment.teacher;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */
@Module
public abstract class TeachersModule {

    @Binds
    abstract TeachersContract.Presenter presenter(TeachersPresenter presenter);

}
