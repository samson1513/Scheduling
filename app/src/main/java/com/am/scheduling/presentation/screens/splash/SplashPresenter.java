package com.am.scheduling.presentation.screens.splash;

import com.am.scheduling.presentation.abc.core.base.BasePresenterImpl;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SplashPresenter extends BasePresenterImpl<SplashContract.View> implements SplashContract.Presenter {

    private SplashContract.Model model;

    public SplashPresenter(SplashContract.View view, SplashContract.Model model) {
        super(view);
        this.model = model;
    }

    @Override
    public void subscribe() {
        addDisposable(Single.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toCompletable()
                .subscribe(() -> getView().startMainScreen())
        );
    }
}