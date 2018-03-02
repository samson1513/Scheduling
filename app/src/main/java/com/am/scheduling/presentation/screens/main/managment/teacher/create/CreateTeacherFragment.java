package com.am.scheduling.presentation.screens.main.managment.teacher.create;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.am.scheduling.R;
import com.am.scheduling.presentation.core.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CreateTeacherFragment extends BaseFragment<CreateTeacherContract.Presenter>
        implements CreateTeacherContract.View {

    @Inject
    CreateTeacherContract.Presenter mPresenter;

    @BindView(R.id.edit_first_name_fct)
    EditText mEditFirstNameFct;
    @BindView(R.id.til_first_name_fct)
    TextInputLayout mTilFirstNameFct;
    @BindView(R.id.edit_last_name_fct)
    EditText mEditLastNameFct;
    @BindView(R.id.til_last_name_fct)
    TextInputLayout mTilLastNameFct;

    @Override
    public CreateTeacherContract.Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_create_teacher;
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_done, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mi_done_md:
                getPresenter().save(mEditFirstNameFct.getText().toString(), mEditLastNameFct.getText().toString());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void finish() {
        getNavigator().handleBack(getContext());
    }

}
