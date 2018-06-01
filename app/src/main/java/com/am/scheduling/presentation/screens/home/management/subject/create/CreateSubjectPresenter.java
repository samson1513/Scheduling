package com.am.scheduling.presentation.screens.home.management.subject.create;

import android.text.TextUtils;

import com.am.scheduling.data.database.models.Subject;
import com.am.scheduling.presentation.abc.core.base.BasePresenterImpl;

public class CreateSubjectPresenter extends BasePresenterImpl<CreateSubjectContract.View> implements CreateSubjectContract.Presenter {

    private CreateSubjectContract.Model model;

    public CreateSubjectPresenter(CreateSubjectContract.View view, CreateSubjectContract.Model model) {
        super(view);
        this.model = model;
    }

    @Override
    public void save(String name) {
        if (!TextUtils.isEmpty(name)) {
            addDisposable(model.mCreateCase.async(new Subject(name))
                    .subscribe(getView()::finish, Throwable::printStackTrace)
            );
        }
    }

    @Override
    public void subscribe() {

    }
}