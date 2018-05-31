package com.am.scheduling.presentation.screens.home.root.room.create;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.base.BaseFragment;

import butterknife.BindView;


public class CreateRoomFragment extends BaseFragment<CreateRoomContract.Presenter> implements CreateRoomContract.View {

    public static CreateRoomFragment newInstance() {
        CreateRoomFragment fragment = new CreateRoomFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @BindView(R.id.edit_name_fcr)
    EditText mEditNameFcr;
    @BindView(R.id.til_name_fcr)
    TextInputLayout mTilNameFcr;
    @BindView(R.id.edit_capacity_fcr)
    EditText mEditCapacityFcr;
    @BindView(R.id.til_capacity_fcr)
    TextInputLayout mTilCapacityFcr;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_create_room;
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
                getPresenter().save(mEditNameFcr.getText().toString(), mEditCapacityFcr.getText().toString());
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

