package com.am.scheduling.presentation.screens.main.managment.subject;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */
@Module
public abstract class SubjectsModule {

    @Binds
    abstract SubjectsContract.Presenter presenter(SubjectsPresenter presenter);

}
