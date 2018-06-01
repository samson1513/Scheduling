package com.am.scheduling.presentation.screens.home.management;

import android.os.Bundle;
import android.widget.Button;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.base.BaseFragment;
import com.am.scheduling.presentation.screens.home.management.group.list.GroupListFragment;
import com.am.scheduling.presentation.screens.home.management.room.list.RoomListFragment;
import com.am.scheduling.presentation.screens.home.management.subject.list.SubjectListFragment;
import com.am.scheduling.presentation.screens.home.management.teacher.list.TeacherListFragment;
import com.am.scheduling.presentation.screens.home.management.timeslot.list.TimeslotListFragment;
import com.am.scheduling.presentation.utils.ui.RxView;

import butterknife.BindView;


public class ManagementFragment extends BaseFragment<ManagementContract.Presenter> implements ManagementContract.View {

    public static ManagementFragment newInstance() {
        ManagementFragment fragment = new ManagementFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @BindView(R.id.btn_rooms)
    Button mBtnRooms;
    @BindView(R.id.btn_groups)
    Button mBtnGroups;
    @BindView(R.id.btn_teachers)
    Button mBtnTeachers;
    @BindView(R.id.btn_subjects)
    Button mBtnSubjects;
    @BindView(R.id.btn_schedules)
    Button mBtnSchedules;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_management;
    }

    @Override
    public void initUI() {
        RxView.safeClicks(mBtnRooms)
                .subscribe(o -> getPresenter().openRoomsScreen());
        RxView.safeClicks(mBtnGroups)
                .subscribe(o -> getPresenter().openGroupsScreen());
        RxView.safeClicks(mBtnTeachers)
                .subscribe(o -> getPresenter().openTeachersScreen());
        RxView.safeClicks(mBtnSubjects)
                .subscribe(o -> getPresenter().openSubjectsScreen());
        RxView.safeClicks(mBtnSchedules)
                .subscribe(o -> getPresenter().openSchedulesScreen());
    }

    @Override
    public void startRoomsScreen() {
        getNavigator().switchFragment(RoomListFragment.newInstance());
    }

    @Override
    public void startGroupsScreen() {
        getNavigator().switchFragment(GroupListFragment.newInstance());
    }

    @Override
    public void startTeachersScreen() {
        getNavigator().switchFragment(TeacherListFragment.newInstance());
    }

    @Override
    public void startSubjectsScreen() {
        getNavigator().switchFragment(SubjectListFragment.newInstance());
    }

    @Override
    public void startSchedulesScreen() {
        getNavigator().switchFragment(TimeslotListFragment.newInstance());
    }
}

