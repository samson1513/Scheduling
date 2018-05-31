package com.am.scheduling.presentation.screens.main.creator;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

@Module
public interface CreatorModule {

    @Binds
    CreatorContract.Presenter presenter(CreatorPresenter presenter);
}
