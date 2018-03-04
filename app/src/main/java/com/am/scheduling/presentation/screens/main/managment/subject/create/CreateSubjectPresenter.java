package com.am.scheduling.presentation.screens.main.managment.subject.create;

import android.text.TextUtils;

import com.am.scheduling.domain.base.completable.DefaultCompletableObserver;
import com.am.scheduling.domain.usecases.subject.CreateSubjectCase;
import com.am.scheduling.presentation.core.base.BasePresenterImpl;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CreateSubjectPresenter extends BasePresenterImpl<CreateSubjectContract.View>
        implements CreateSubjectContract.Presenter {

    private CreateSubjectCase mCreateCase;

    @Inject
    public CreateSubjectPresenter(CreateSubjectCase createCase) {
        mCreateCase = createCase;
    }

    @Override
    public void save(String name) {
        if (!TextUtils.isEmpty(name)) {
            addDisposable(mCreateCase.with(name).execute(new CreateObserver()));
        }
    }

    class CreateObserver extends DefaultCompletableObserver {

        @Override
        public void onComplete() {
            getView().finish();
        }
    }
}
