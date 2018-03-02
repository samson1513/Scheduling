package com.am.scheduling.presentation.screens.main.managment.teacher.create;

import android.text.TextUtils;

import com.am.scheduling.domain.base.completable.DefaultCompletableObserver;
import com.am.scheduling.domain.usecases.teacher.CreateTeacherCase;
import com.am.scheduling.presentation.core.base.BasePresenterImpl;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CreateTeacherPresenter extends BasePresenterImpl<CreateTeacherContract.View>
        implements CreateTeacherContract.Presenter {

    private CreateTeacherCase mCreateCase;

    @Inject
    public CreateTeacherPresenter(CreateTeacherCase createTeacherCase) {
        mCreateCase = createTeacherCase;
    }

    @Override
    public void save(String first, String last) {
        if (!TextUtils.isEmpty(first) && !TextUtils.isEmpty(last)) {
            addDisposable(mCreateCase.with(first, last)
                    .execute(new CreateObserver())
            );
        }
    }

    class CreateObserver extends DefaultCompletableObserver {

        @Override
        public void onComplete() {
            getView().finish();
        }
    }
}
