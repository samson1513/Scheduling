package com.am.scheduling.presentation.screens.home.schedule.generator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.am.scheduling.R;
import com.am.scheduling.chapter5.Timetable;
import com.am.scheduling.presentation.abc.core.content.ContentFragment;
import com.am.scheduling.presentation.screens.home.HomeActivity;
import com.am.scheduling.presentation.utils.Consts;
import com.am.scheduling.presentation.utils.ui.RxView;

import java.io.File;

import butterknife.BindView;


public class GeneratorFragment extends ContentFragment<GeneratorContract.Presenter> implements GeneratorContract.View {


    public static GeneratorFragment newInstance(Timetable timetable) {
        GeneratorFragment fragment = new GeneratorFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Consts.KEY_RESULT, timetable);
        fragment.setArguments(bundle);
        return fragment;
    }

    @BindView(R.id.tv_file)
    TextView mTvFile;
    @BindView(R.id.btn_open)
    Button mBtnOpen;
    @BindView(R.id.btn_retry)
    Button mBtnRetry;
    @BindView(R.id.tv_to_home)
    TextView mTvToHome;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_generator;
    }

    @Override
    public void initUI() {
        RxView.safeClicks(mBtnOpen)
                .subscribe(o -> getPresenter().openFile());
        RxView.safeClicks(mBtnRetry)
                .subscribe(o -> getPresenter().retry());
        RxView.safeClicks(mTvToHome)
                .subscribe(o -> getPresenter().goToHome());

        getPresenter().subscribe();
    }

    @Override
    public void showResult(String fileName) {
        mTvFile.setText(fileName);
    }

    @Override
    public void openFile(File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.ms-excel");
        getNavigator().startActivity(intent);
    }

    @Override
    public void startHomeScreen() {
        getNavigator().startActivity(HomeActivity.newLaunchIntent(getContext()), true);
    }
}

