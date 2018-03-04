package com.am.scheduling.presentation.screens.main.managment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.am.scheduling.R;
import com.am.scheduling.presentation.core.base.BaseFragment;
import com.am.scheduling.presentation.core.tab.TabAdapter;
import com.am.scheduling.presentation.screens.main.managment.group.GroupsFragment;
import com.am.scheduling.presentation.screens.main.managment.room.RoomsFragment;
import com.am.scheduling.presentation.screens.main.managment.schedule.SchedulesFragment;
import com.am.scheduling.presentation.screens.main.managment.subject.SubjectsFragment;
import com.am.scheduling.presentation.screens.main.managment.teacher.TeachersFragment;
import com.am.scheduling.presentation.utils.Consts;
import com.am.scheduling.presentation.utils.ui.RxView;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Alex Michenko
 * on 28.02.2018.
 */

public class ManagementFragment extends BaseFragment<ManagementContract.Presenter>
        implements ManagementContract.View {

    @Inject
    ManagementContract.Presenter mPresenter;
    @BindView(R.id.tabs_entries_fm)
    TabLayout mTabsEntriesFm;
    @BindView(R.id.pager_entries_fm)
    ViewPager mPagerEntriesFm;
    @BindView(R.id.fab_create_fm)
    FloatingActionButton mFabCreateFm;

    private TabAdapter mTabAdapter;
    private ViewPager.OnPageChangeListener mPageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == ViewPager.SCROLL_STATE_DRAGGING) {
                mFabCreateFm.hide(fabListener);
            } else {
                mFabCreateFm.show(fabListener);
            }
        }
    };

    private FloatingActionButton.OnVisibilityChangedListener fabListener = new FloatingActionButton.OnVisibilityChangedListener() {
        @Override
        public void onShown(FloatingActionButton fab) {
            fab.setVisibility(View.VISIBLE);
        }

        @Override
        public void onHidden(FloatingActionButton fab) {
            fab.setVisibility(View.INVISIBLE);
        }
    };

    @Override
    protected void parseArguments(Bundle args) {
        mTabAdapter = new TabAdapter(getChildFragmentManager());
        mTabAdapter.addFragment(new RoomsFragment(), "Rooms");
        mTabAdapter.addFragment(new GroupsFragment(), "Groups");
        mTabAdapter.addFragment(new TeachersFragment(), "Teachers");
        mTabAdapter.addFragment(new SubjectsFragment(), "Subjects");
        mTabAdapter.addFragment(new SchedulesFragment(), "Schedules");
    }

    @Override
    public ManagementContract.Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_managment;
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState) {
        mPagerEntriesFm.setAdapter(mTabAdapter);
        mTabsEntriesFm.setupWithViewPager(mPagerEntriesFm);
        mPagerEntriesFm.addOnPageChangeListener(mPageChangeListener);
        RxView.safeClicks(mFabCreateFm).subscribe(o ->
                mTabAdapter.getItem(mPagerEntriesFm.getCurrentItem()).onActivityResult(Consts.RC_CREATE, -1, null));
    }

    @Override
    public void onDestroyView() {
        mPagerEntriesFm.removeOnPageChangeListener(mPageChangeListener);
        super.onDestroyView();
    }
}
