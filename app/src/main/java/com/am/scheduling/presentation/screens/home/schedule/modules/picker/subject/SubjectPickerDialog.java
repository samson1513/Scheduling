package com.am.scheduling.presentation.screens.home.schedule.modules.picker.subject;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.am.scheduling.R;
import com.am.scheduling.data.database.models.Subject;
import com.am.scheduling.presentation.screens.home.management.subject.list.adapter.SubjectDH;
import com.am.scheduling.presentation.screens.home.management.subject.list.adapter.SubjectsAdapter;
import com.am.scheduling.presentation.screens.home.schedule.modules.picker.PickerCallback;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by Alex Michenko
 * on 31.05.2018.
 */
public class SubjectPickerDialog extends BottomSheetDialogFragment
        implements HasSupportFragmentInjector, SubjectPickerContract.View {

    @Inject
    DispatchingAndroidInjector<Fragment> childFragmentInjector;
    @Inject
    SubjectsAdapter adapter;
    @Inject
    SubjectPickerContract.Presenter presenter;

    @BindView(R.id.rv_bfl_list)
    RecyclerView mRvBflList;
    private Unbinder mUnbinder;

    private PickerCallback<Subject> callback;

    public static SubjectPickerDialog newInstance(PickerCallback<Subject> callback) {
        SubjectPickerDialog dialog = new SubjectPickerDialog();
        dialog.setCallback(callback);
        return dialog;
    }

    public void setCallback(PickerCallback<Subject> callback) {
        this.callback = callback;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);

        dialog.setOnShowListener(dialog1 -> {
            BottomSheetDialog d = (BottomSheetDialog) dialog1;

            FrameLayout bottomSheet = d.findViewById(android.support.design.R.id.design_bottom_sheet);
            if (bottomSheet != null) {
                BottomSheetBehavior<FrameLayout> behavior = BottomSheetBehavior.from(bottomSheet);
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                behavior.setHideable(false);
            }
        });

        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_fragment_list, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        mRvBflList.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvBflList.setAdapter(adapter);

        adapter.setOnItemClickListener((adapter1, view, position) ->
                presenter.selectItem(adapter.getItem(position))
        );

        presenter.subscribe();
    }

    @Override
    public void onDestroyView() {
        mUnbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return childFragmentInjector;
    }

    @Override
    public void setItems(List<SubjectDH> items) {
        adapter.setNewData(items);
    }

    @Override
    public void finishWithResult(Subject subject) {
        callback.call(subject);
        dismiss();
    }
}
