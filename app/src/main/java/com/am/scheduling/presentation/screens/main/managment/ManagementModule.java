package com.am.scheduling.presentation.screens.main.managment;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Module
public interface ManagementModule {

    @Binds
    ManagementContract.Presenter presenter(ManagementPresenter presenter);
}
