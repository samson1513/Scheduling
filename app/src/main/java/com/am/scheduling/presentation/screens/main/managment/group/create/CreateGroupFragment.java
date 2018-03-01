package com.am.scheduling.presentation.screens.main.managment.group.create;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.am.scheduling.R;
import com.am.scheduling.presentation.core.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class CreateGroupFragment extends BaseFragment<CreateGroupContract.Presenter>
        implements CreateGroupContract.View {

    @Inject
    CreateGroupContract.Presenter mPresenter;

    @BindView(R.id.edit_name_fcg)
    EditText mEditNameFcg;
    @BindView(R.id.til_name_fcg)
    TextInputLayout mTilNameFcg;
    @BindView(R.id.edit_size_fcg)
    EditText mEditSizeFcg;
    @BindView(R.id.til_size_fcg)
    TextInputLayout mTilSizeFcg;

    @Override
    public CreateGroupContract.Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_create_group;
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
                getPresenter().save(mEditNameFcg.getText().toString(), mEditSizeFcg.getText().toString());
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
