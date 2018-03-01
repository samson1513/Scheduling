package com.am.scheduling.di.modules;


import com.am.scheduling.presentation.core.content.navigation.Navigator;
import com.am.scheduling.presentation.core.content.navigation.NavigatorImpl;
import com.am.scheduling.presentation.core.multibackstack.navigation.MultiBackStackNavigator;
import com.am.scheduling.presentation.core.multibackstack.navigation.MultiBackStackNavigatorImpl;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

@Module
public abstract class NavigationModule {

    @Binds
    abstract Navigator provideNav(final NavigatorImpl navigator);
    @Binds
    abstract MultiBackStackNavigator provideMultiBackStackNavigator(final MultiBackStackNavigatorImpl navigator);
}
