package com.am.scheduling.presentation.core.dialog;

import android.os.Bundle;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.am.scheduling.R;
import com.am.scheduling.presentation.utils.Consts;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public class ChooserDialog extends BottomSheetDialogFragment {

    public static ChooserDialog newInstance(String title, @MenuRes int resId, OnItemSelectedListener listener) {
        ChooserDialog dialog = new ChooserDialog();
        Bundle bundle = new Bundle();
        bundle.putInt(Consts.KEY_RESOURCE, resId);
        bundle.putString(Consts.KEY_TITLE, title);
        dialog.setArguments(bundle);
        dialog.setListener(listener);
        return dialog;
    }

    @BindView(R.id.nv_dc_list)
    protected NavigationView nvDcList;

    @BindView(R.id.tv_dc_title)
    protected TextView tvDcTitle;

    private Unbinder unbinder;
    private OnItemSelectedListener listener;
    @MenuRes
    private int menuRes;
    private String title;

    @Override
    public int getTheme() {
        return R.style.ChooserTheme;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) parseArguments(getArguments());
    }

    protected void parseArguments(Bundle args) {
        title = args.getString(Consts.KEY_TITLE);
        menuRes = args.getInt(Consts.KEY_RESOURCE);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_chooser, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        nvDcList.inflateMenu(menuRes);
        nvDcList.setNavigationItemSelectedListener(this::onItemSelected);
        if (title == null || title.equals(""))
            tvDcTitle.setVisibility(View.GONE);
        else
            tvDcTitle.setText(title);
    }

    @Override
    public void onDestroyView() {
        if (unbinder != null) unbinder.unbind();
        super.onDestroyView();
    }

    protected boolean onItemSelected(@NonNull MenuItem item) {
        listener.onNavigationItemSelected(item);
        dismiss();
        return true;
    }

    public void setListener(OnItemSelectedListener listener) {
        this.listener = listener;
    }

    public interface OnItemSelectedListener {
        void onNavigationItemSelected(@NonNull MenuItem item);
    }
}
