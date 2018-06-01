package com.am.scheduling.presentation.screens.home.schedule.modules;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.am.scheduling.R;
import com.am.scheduling.chapter5.Timetable;
import com.am.scheduling.data.database.models.Group;
import com.am.scheduling.presentation.abc.core.content.ContentFragment;
import com.am.scheduling.presentation.custom.NonSwipeableViewPager;
import com.am.scheduling.presentation.screens.home.schedule.modules.adapter.group_module.GroupModulesAdapter;
import com.am.scheduling.presentation.screens.home.schedule.modules.adapter.group_module.GroupModulesDH;
import com.am.scheduling.presentation.screens.home.schedule.modules.picker.subject.SubjectPickerDialog;
import com.am.scheduling.presentation.screens.home.schedule.modules.picker.teacher.TeacherPickerDialog;
import com.am.scheduling.presentation.screens.home.schedule.timeslotpicker.TimeslotPickerFragment;
import com.am.scheduling.presentation.utils.Consts;
import com.am.scheduling.presentation.utils.ui.RxView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


public class ModulesFragment extends ContentFragment<ModulesContract.Presenter> implements ModulesContract.View {


    public static ModulesFragment newInstance(ArrayList<Group> groups) {
        ModulesFragment fragment = new ModulesFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Consts.KEY_LIST, groups);
        fragment.setArguments(bundle);
        return fragment;
    }

    @BindView(R.id.tl_group_names_fm)
    TabLayout mTlGroupNamesFm;
    @BindView(R.id.pager_modules_fm)
    NonSwipeableViewPager mPagerModulesFm;
    @BindView(R.id.btn_next_fm)
    Button mBtnNextFm;

    @Inject
    GroupModulesAdapter adapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_modules;
    }

    @Override
    public void initUI() {
        mPagerModulesFm.setAdapter(adapter);
        mTlGroupNamesFm.setupWithViewPager(mPagerModulesFm, true);

        RxView.safeClicks(mBtnNextFm)
                .subscribe(o -> {
                    int position = mPagerModulesFm.getCurrentItem();
                    getPresenter().next(adapter.getItem(position), position);
                });

        mTlGroupNamesFm.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int currentPosition = mPagerModulesFm.getCurrentItem();
                mTlGroupNamesFm.getTabAt(currentPosition).select();
                mPagerModulesFm.setCurrentItem(currentPosition, false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        adapter.setOnItemClickListener((view, position) -> {
            GroupModulesDH dh = adapter.getItem(position);
            switch (view.getId()) {
                case R.id.et_subject_fgm:
                    SubjectPickerDialog.newInstance(data -> {
                        dh.setSubject(data);
                        adapter.updateItem(dh, position);
                    }).show(activity.getSupportFragmentManager(), "picker");
                    break;
                case R.id.et_teacher_fgm:
                    TeacherPickerDialog.newInstance(data -> {
                        dh.setTeacher(data);
                        adapter.updateItem(dh, position);
                    }).show(activity.getSupportFragmentManager(), "picker");
                    break;
                case R.id.btn_add_fgm:
                    dh.addModule();
                    adapter.updateItem(dh, position);
                    break;
                case R.id.et_count_fgm:
                    String count = ((EditText) view).getText().toString();
                    dh.setCount(TextUtils.isEmpty(count) ? 0 : Integer.valueOf(count));
                    break;
            }
        });

        if (adapter.getCount() == 0) {
            getPresenter().subscribe();
        }
    }

    @Override
    public void setTabs(List<GroupModulesDH> items) {
        adapter.setItems(items);
    }

    @Override
    public void selectTab(int position) {
        mPagerModulesFm.setCurrentItem(position);
    }

    @Override
    public void startGeneratorScreen(Timetable timetable) {
        getNavigator().switchFragment(TimeslotPickerFragment.newInstance(timetable));
    }
}

