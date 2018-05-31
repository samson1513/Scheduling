package com.am.scheduling.presentation.screens.home.root;

import android.os.Bundle;
import android.widget.Button;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.base.BaseFragment;
import com.am.scheduling.presentation.screens.home.root.management.ManagementFragment;
import com.am.scheduling.presentation.utils.ui.RxView;

import butterknife.BindView;


public class RootFragment extends BaseFragment<RootContract.Presenter> implements RootContract.View {

    public static RootFragment newInstance() {
        RootFragment fragment = new RootFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @BindView(R.id.btn_manager)
    Button mBtnManager;
    @BindView(R.id.btn_generator)
    Button mBtnGenerator;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_root;
    }

    @Override
    public void initUI() {
        RxView.safeClicks(mBtnManager)
                .subscribe(o -> getPresenter().openManagementScreen());
        RxView.safeClicks(mBtnGenerator)
                .subscribe(o -> getPresenter().openGeneratorScreen());
    }

    @Override
    public void startManagementScreen() {
        getNavigator().switchFragment(ManagementFragment.newInstance());
    }

    @Override
    public void startGeneratorScreen() {

    }
}

