package com.am.scheduling.presentation.core.dialog;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.view.View;

import com.am.scheduling.presentation.utils.Consts;


/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public class SingleChooserDialog extends ChooserDialog {

    public static SingleChooserDialog newInstance(String title, @MenuRes int resId, @IdRes int itemId, OnItemSelectedListener listener) {
        SingleChooserDialog dialog = new SingleChooserDialog();
        Bundle bundle = new Bundle();
        bundle.putInt(Consts.KEY_RESOURCE, resId);
        bundle.putInt(Consts.KEY_RESOURCE_ID, itemId);
        bundle.putString(Consts.KEY_TITLE, title);
        dialog.setArguments(bundle);
        dialog.setListener(listener);
        return dialog;
    }

    @IdRes
    private int itemId;

    @Override
    protected void parseArguments(Bundle args) {
        super.parseArguments(args);
        itemId = args.getInt(Consts.KEY_RESOURCE_ID);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nvDcList.setCheckedItem(itemId);
    }

    @Override
    protected boolean onItemSelected(@NonNull MenuItem item) {
        return !item.isChecked() && super.onItemSelected(item);
    }
}
