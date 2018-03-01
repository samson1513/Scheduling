package com.am.scheduling.presentation.core.content.placeholder;

import android.support.annotation.IntDef;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import butterknife.ButterKnife;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public class Holder {

    @IntDef({NONE, PROGRESS, NETWORK, UNKNOWN, EMPTY, NO_PERMISSION, NO_GPS})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {}

    public static final int NONE = -1;
    public static final int PROGRESS = 0;
    public static final int EMPTY = 1;
    public static final int NETWORK = 2;
    public static final int UNKNOWN = 3;
    public static final int NO_PERMISSION = 4;
    public static final int NO_GPS = 5;

    protected View holder;
    protected View content;


    public Holder(@LayoutRes int holderRes, @NonNull View content) {
        ViewGroup parent = (ViewGroup) content.getParent();
        this.holder = LayoutInflater.from(content.getContext()).inflate(holderRes, parent, false);
        this.content = content;

        holder.setVisibility(View.GONE);

        int pos = parent.indexOfChild(content);
        parent.addView(holder, pos + 1, content.getLayoutParams());

        ButterKnife.bind(this, holder);
    }

    public void setContentView(@NonNull View content) {
        ViewGroup parent = (ViewGroup) this.content.getParent();
        parent.removeView(holder);

        ViewGroup newParent = (ViewGroup) content.getParent();
        newParent.addView(holder, newParent.indexOfChild(content) + 1, content.getLayoutParams());

        this.content = content;
    }

    public void show() {
        if (holder.getVisibility() != View.VISIBLE) {
            content.setVisibility(View.GONE);
            holder.setVisibility(View.VISIBLE);
        }
    }

    public void hide() {
        if (holder.getVisibility() != View.GONE) {
            content.setVisibility(View.VISIBLE);
            holder.setVisibility(View.GONE);
        }
    }
}
