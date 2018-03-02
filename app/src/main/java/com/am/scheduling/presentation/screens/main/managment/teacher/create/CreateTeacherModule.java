package com.am.scheduling.presentation.screens.main.managment.teacher.create;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Module
public abstract class CreateTeacherModule {

    @Binds
    abstract CreateTeacherContract.Presenter presenter(CreateTeacherPresenter presenter);
}
