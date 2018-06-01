package com.am.scheduling.presentation.screens.home.schedule.timeslotpicker;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.am.scheduling.R;
import com.am.scheduling.chapter5.Timetable;
import com.am.scheduling.presentation.abc.core.list.ListFragment;
import com.am.scheduling.presentation.abc.core.list.adapter.SimpleAdapter;
import com.am.scheduling.presentation.screens.home.schedule.generator.GeneratorFragment;
import com.am.scheduling.presentation.screens.home.schedule.timeslotpicker.adapter.CheckTimeslotAdapter;
import com.am.scheduling.presentation.screens.home.schedule.timeslotpicker.adapter.CheckTimeslotDH;
import com.am.scheduling.presentation.utils.Consts;
import com.am.scheduling.presentation.utils.ui.RxView;

import javax.inject.Inject;

import butterknife.BindView;


public class TimeslotPickerFragment extends ListFragment<CheckTimeslotDH, TimeslotPickerContract.Presenter> implements TimeslotPickerContract.View {

    public static TimeslotPickerFragment newInstance(Timetable timetable) {
        TimeslotPickerFragment fragment = new TimeslotPickerFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Consts.KEY_RESULT, timetable);
        fragment.setArguments(bundle);
        return fragment;
    }

    @BindView(R.id.rv_bfl_list)
    RecyclerView mRvBflList;
    @BindView(R.id.btn_next)
    Button mBtnNext;

    @Inject
    CheckTimeslotAdapter adapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_timeslot_picker;
    }

    @Override
    public void initUI() {
        adapter.setOnItemClickListener((adapter1, view, position) ->
                getPresenter().check(adapter.getItem(position), position)
        );

        RxView.safeClicks(mBtnNext)
                .subscribe(o -> getPresenter().next());

        getPresenter().subscribe();
    }

    @Override
    public SimpleAdapter<CheckTimeslotDH> getAdapter() {
        return adapter;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return mRvBflList;
    }

    @Override
    public void startGeneratorScreen(Timetable timetable) {
        getNavigator().switchFragment(GeneratorFragment.newInstance(timetable));
    }
}

