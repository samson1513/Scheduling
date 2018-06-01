package com.am.scheduling.presentation.screens.home.management.teacher.create;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.base.BaseFragment;

import butterknife.BindView;


public class CreateTeacherFragment extends BaseFragment<CreateTeacherContract.Presenter> implements CreateTeacherContract.View {

    public static CreateTeacherFragment newInstance() {
        CreateTeacherFragment fragment = new CreateTeacherFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @BindView(R.id.edit_first_name_fct)
    EditText mEditFirstNameFct;
    @BindView(R.id.til_first_name_fct)
    TextInputLayout mTilFirstNameFct;
    @BindView(R.id.edit_last_name_fct)
    EditText mEditLastNameFct;
    @BindView(R.id.til_last_name_fct)
    TextInputLayout mTilLastNameFct;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_create_teacher;
    }

    @Override
    public void initUI() {

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
        getNavigator().handleBack();
    }
}

