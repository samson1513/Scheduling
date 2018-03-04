package com.am.scheduling.presentation.screens.main.managment.subject;

import com.am.scheduling.domain.base.single.DefaultSingleObserver;
import com.am.scheduling.domain.usecases.subject.SubjectListCase;
import com.am.scheduling.presentation.core.list.ListPresenterImpl;
import com.am.scheduling.presentation.screens.main.managment.subject.adapter.SubjectDH;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class SubjectsPresenter extends ListPresenterImpl<SubjectsContract.View>
        implements SubjectsContract.Presenter {

    private SubjectListCase mSubjectListCase;

    @Inject
    public SubjectsPresenter(SubjectListCase roomListCase) {
        mSubjectListCase = roomListCase;
    }

    @Override
    public void loadData() {
        addDisposable(mSubjectListCase.execute(new ListObserver()));
    }

    @Override
    public void createSubject() {
        getView().startCreateSubjectScreen();
    }

    class ListObserver extends DefaultSingleObserver<List<SubjectDH>> {

        @Override
        public void onSuccess(List<SubjectDH> roomDHS) {
            getView().setItems(roomDHS);
        }
    }
}
