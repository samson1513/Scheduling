package com.am.scheduling.presentation.utils;

import android.content.Context;
import android.support.annotation.StringRes;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public class ResourceManager {

    private WeakReference<Context> context;

    @Inject
    public ResourceManager(Context context) {
        this.context = new WeakReference<>(context);
    }

    public String getString(@StringRes int resId) {
        return context.get().getString(resId);
    }

    public String getString(@StringRes int resId, Object... args) {
        return context.get().getString(resId, args);
    }
}
