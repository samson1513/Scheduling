package com.am.scheduling.presentation.screens.splash;


import com.am.scheduling.presentation.core.base.BasePresenterImpl;
import com.am.scheduling.presentation.utils.authentication.AuthHelper;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alex Michenko
 * on 08.02.2018.
 */

public class SplashPresenter extends BasePresenterImpl<SplashContract.View>
        implements SplashContract.Presenter {

    @Inject
    public SplashPresenter() {
    }

    @Override
    public void onUiReady() {
        addDisposable(Single.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toCompletable()
                .subscribe(() -> getView().startMainScreen())
        );
    }
}
