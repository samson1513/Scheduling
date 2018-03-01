package com.am.scheduling.presentation.screens.main.managment.room.create;

import android.text.TextUtils;

import com.am.scheduling.domain.base.completable.DefaultCompletableObserver;
import com.am.scheduling.domain.usecases.room.CreateRoomCase;
import com.am.scheduling.presentation.core.base.BasePresenterImpl;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CreateRoomPresenter extends BasePresenterImpl<CreateRoomContract.View>
        implements CreateRoomContract.Presenter {

    private CreateRoomCase mCreateRoomCase;

    @Inject
    public CreateRoomPresenter(CreateRoomCase createRoomCase) {
        mCreateRoomCase = createRoomCase;
    }

    @Override
    public void save(String name, String capacity) {
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(capacity)) {
            addDisposable(mCreateRoomCase.with(name, Integer.parseInt(capacity))
                    .execute(new CreateRoomObserver())
            );
        }
    }

    class CreateRoomObserver extends DefaultCompletableObserver {

        @Override
        public void onComplete() {
            getView().finish();
        }
    }
}
