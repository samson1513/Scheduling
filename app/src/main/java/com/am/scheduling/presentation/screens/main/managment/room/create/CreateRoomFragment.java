package com.am.scheduling.presentation.screens.main.managment.room.create;

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

public class CreateRoomFragment extends BaseFragment<CreateRoomContract.Presenter>
        implements CreateRoomContract.View {

    @Inject
    CreateRoomContract.Presenter mPresenter;
    @BindView(R.id.edit_name_fcr)
    EditText mEditNameFcr;
    @BindView(R.id.til_name_fcr)
    TextInputLayout mTilNameFcr;
    @BindView(R.id.edit_capacity_fcr)
    EditText mEditCapacityFcr;
    @BindView(R.id.til_capacity_fcr)
    TextInputLayout mTilCapacityFcr;

    @Override
    public CreateRoomContract.Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_create_room;
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
                getPresenter().save(mEditNameFcr.getText().toString(), mEditCapacityFcr.getText().toString());
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
