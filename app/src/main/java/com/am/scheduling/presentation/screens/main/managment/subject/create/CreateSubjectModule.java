package com.am.scheduling.presentation.screens.main.managment.subject.create;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Module
public abstract class CreateSubjectModule {

    @Binds
    abstract CreateSubjectContract.Presenter presenter(CreateSubjectPresenter presenter);
}
