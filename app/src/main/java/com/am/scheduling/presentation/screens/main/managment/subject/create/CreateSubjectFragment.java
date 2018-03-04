package com.am.scheduling.presentation.screens.main.managment.subject.create;

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

public class CreateSubjectFragment extends BaseFragment<CreateSubjectContract.Presenter>
        implements CreateSubjectContract.View {

    @Inject
    CreateSubjectContract.Presenter mPresenter;

    @BindView(R.id.edit_fcs_name)
    EditText mEditFcsName;
    @BindView(R.id.til_fcs_name)
    TextInputLayout mTilFcsName;

    @Override
    public CreateSubjectContract.Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_create_subject;
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
                getPresenter().save(mEditFcsName.getText().toString());
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
