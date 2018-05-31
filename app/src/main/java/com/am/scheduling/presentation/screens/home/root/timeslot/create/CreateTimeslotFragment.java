package com.am.scheduling.presentation.screens.home.root.timeslot.create;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.am.scheduling.R;
import com.am.scheduling.presentation.abc.core.base.BaseFragment;
import com.am.scheduling.presentation.screens.home.root.timeslot.create.adapter.day.DayDH;
import com.am.scheduling.presentation.screens.home.root.timeslot.create.adapter.day.DaysAdapter;
import com.am.scheduling.presentation.screens.home.root.timeslot.create.adapter.slot.SlotDH;
import com.am.scheduling.presentation.screens.home.root.timeslot.create.adapter.slot.SlotsAdapter;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


public class CreateTimeslotFragment extends BaseFragment<CreateTimeslotContract.Presenter> implements CreateTimeslotContract.View {

    public static CreateTimeslotFragment newInstance() {
        CreateTimeslotFragment fragment = new CreateTimeslotFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Inject
    DaysAdapter mDaysAdapter;
    @Inject
    SlotsAdapter mSlotsAdapter;

    @BindView(R.id.list_days_fcsc)
    RecyclerView mListDaysFcsc;
    @BindView(R.id.list_slots_fcsc)
    RecyclerView mListSlotsFcsc;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_create_schedule;
    }

    @Override
    public void initUI() {
        mListDaysFcsc.setAdapter(mDaysAdapter);
        mListDaysFcsc.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mDaysAdapter.setOnItemClickListener((adapter, view, position) -> {
            DayDH dh = mDaysAdapter.getData().get(position);
            dh.setSelected(!dh.isSelected());
            mDaysAdapter.setData(position, dh);
        });

        mListSlotsFcsc.setAdapter(mSlotsAdapter);
        mListSlotsFcsc.setLayoutManager(new LinearLayoutManager(getContext()));
        mSlotsAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            switch (view.getId()) {
                case R.id.text_start_time_is:
                    getPresenter().onPickStartTime(mSlotsAdapter.getItem(position), position);
                    break;
                case R.id.text_end_time_is:
                    getPresenter().onPickEndTime(mSlotsAdapter.getItem(position), position);
                    break;
            }
        });

        getPresenter().subscribe();
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
                getPresenter().save(mDaysAdapter.getData(), mSlotsAdapter.getData());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void setDays(List<DayDH> days) {
        mDaysAdapter.setNewData(days);
    }

    @Override
    public void addSlot(SlotDH slotDH) {
        mSlotsAdapter.addData(slotDH);
    }

    @Override
    public void updateSlot(int position, SlotDH slotDH) {
        mSlotsAdapter.setData(position, slotDH);
    }

    @Override
    public void showTimePicker() {
        final Calendar time = Calendar.getInstance();
        new TimePickerDialog(getContext(),
                (view, hourOfDay, minute) -> {
                    time.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    time.set(Calendar.MINUTE, minute);
                    getPresenter().onTimePicked(time);
                },
                time.get(Calendar.HOUR_OF_DAY),
                time.get(Calendar.MINUTE),
                true
        ).show();
    }

    @Override
    public void finish() {
        getNavigator().handleBack();
    }
}

