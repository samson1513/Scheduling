package com.am.scheduling.presentation.screens.home.root.teacher.create;

import android.text.TextUtils;

import com.am.scheduling.data.database.models.Teacher;
import com.am.scheduling.presentation.abc.core.base.BasePresenterImpl;

public class CreateTeacherPresenter extends BasePresenterImpl<CreateTeacherContract.View> implements CreateTeacherContract.Presenter {

    private CreateTeacherContract.Model model;

    public CreateTeacherPresenter(CreateTeacherContract.View view, CreateTeacherContract.Model model) {
        super(view);
        this.model = model;
    }

    @Override
    public void save(String first, String last) {
        if (!TextUtils.isEmpty(first) && !TextUtils.isEmpty(last)) {
            addDisposable(model.mCreateCase.async(new Teacher(String.format("%s %s", first, last)))
                    .subscribe(getView()::finish, Throwable::printStackTrace)
            );
        }
    }

    @Override
    public void subscribe() {

    }
}