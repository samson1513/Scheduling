package com.am.scheduling.presentation.abc.core.placeholder;

import android.util.SparseArray;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 29.12.2017.
 */

public class HolderManager {

    private SparseArray<Holder> holders = new SparseArray<>();
    @Holder.Type
    private int currentType;

    @Inject
    public HolderManager() {
        currentType = Holder.NONE;
    }

    public void putHolder(@Holder.Type int type, Holder holder) {
        holders.put(type, holder);
    }

    public Holder getHolder(@Holder.Type int type) {
        return holders.get(type);
    }

    @Holder.Type
    public int getCurrentType() {
        return currentType;
    }

    public void show(@Holder.Type int type) {
        if (currentType != type) {
            if (currentType != Holder.NONE)
                hide();
            holders.get(type).show();
            currentType = type;
        }
    }

    public void hide() {
        if (currentType != Holder.NONE) {
            holders.get(currentType).hide();
            currentType = Holder.NONE;
        }
    }

    public void clear() {
        if(holders.size() > 0) {
            for(int i = 0; i < holders.size(); ++i) {
                int key = holders.keyAt(i);
                holders.get(key).hide();
            }
        }
    }

}
