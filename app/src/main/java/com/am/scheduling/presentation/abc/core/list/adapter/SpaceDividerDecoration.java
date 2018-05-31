package com.am.scheduling.presentation.abc.core.list.adapter;

import android.graphics.Rect;
import android.support.annotation.IntDef;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Alex Michenko
 * on 22.05.2018.
 */
public class SpaceDividerDecoration extends RecyclerView.ItemDecoration {


    @IntDef({HORIZONTAL, VERTICAL, ALL})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {}

    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    public static final int ALL = 2;

    private int mSpaceHalfPx;
    private int orientation;

    public SpaceDividerDecoration(int gridSpacingPx) {
        this(gridSpacingPx, ALL);
    }

    public SpaceDividerDecoration(int gridSpacingPx, @Orientation int orientation) {
        mSpaceHalfPx = gridSpacingPx / 2;
        this.orientation = orientation;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        switch (orientation) {
            case ALL:
                outRect.left = mSpaceHalfPx;
                outRect.top = mSpaceHalfPx;
                outRect.right = mSpaceHalfPx;
                outRect.bottom = mSpaceHalfPx;
                break;
            case HORIZONTAL:
                outRect.left = mSpaceHalfPx;
                outRect.right = mSpaceHalfPx;
                break;
            case VERTICAL:
                outRect.top = mSpaceHalfPx;
                outRect.bottom = mSpaceHalfPx;
                break;
        }
    }
}
