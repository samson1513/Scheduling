package com.am.scheduling.presentation.screens.home.management.group.create;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.base.BaseFragment;

import butterknife.BindView;


public class CreateGroupFragment extends BaseFragment<CreateGroupContract.Presenter> implements CreateGroupContract.View {

    public static CreateGroupFragment newInstance() {
        CreateGroupFragment fragment = new CreateGroupFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @BindView(R.id.edit_name_fcg)
    EditText mEditNameFcg;
    @BindView(R.id.til_name_fcg)
    TextInputLayout mTilNameFcg;
    @BindView(R.id.edit_size_fcg)
    EditText mEditSizeFcg;
    @BindView(R.id.til_size_fcg)
    TextInputLayout mTilSizeFcg;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_create_group;
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
                getPresenter().save(mEditNameFcg.getText().toString(), mEditSizeFcg.getText().toString());
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

