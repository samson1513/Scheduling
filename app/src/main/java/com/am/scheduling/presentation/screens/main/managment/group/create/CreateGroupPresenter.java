package com.am.scheduling.presentation.screens.main.managment.group.create;

import android.text.TextUtils;

import com.am.scheduling.domain.base.completable.DefaultCompletableObserver;
import com.am.scheduling.domain.usecases.group.CreateGroupCase;
import com.am.scheduling.presentation.core.base.BasePresenterImpl;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CreateGroupPresenter extends BasePresenterImpl<CreateGroupContract.View>
        implements CreateGroupContract.Presenter {

    private CreateGroupCase mCreateCase;

    @Inject
    public CreateGroupPresenter(CreateGroupCase createCase) {
        mCreateCase = createCase;
    }

    @Override
    public void save(String name, String size) {
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(size)) {
            addDisposable(mCreateCase.with(name, Integer.parseInt(size))
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
