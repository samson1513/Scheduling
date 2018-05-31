package com.am.scheduling.presentation.screens.home.root.group.create;

import android.text.TextUtils;

import com.am.scheduling.data.database.models.Group;
import com.am.scheduling.presentation.abc.core.base.BasePresenterImpl;

public class CreateGroupPresenter extends BasePresenterImpl<CreateGroupContract.View> implements CreateGroupContract.Presenter {

    private CreateGroupContract.Model model;

    public CreateGroupPresenter(CreateGroupContract.View view, CreateGroupContract.Model model) {
        super(view);
        this.model = model;
    }

    @Override
    public void save(String name, String capacity) {
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(capacity)) {
            addDisposable(model.mCreateCase.async(new Group(name, Integer.parseInt(capacity)))
                    .subscribe(getView()::finish, Throwable::printStackTrace)
            );
        }
    }

    @Override
    public void subscribe() {

    }
}