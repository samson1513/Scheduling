package com.am.scheduling.presentation.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Alex Michenko
 * on 20.02.2018.
 */

public class DisableableAppBarLayoutBehavior extends AppBarLayout.Behavior {
    private boolean mEnabled = false;

    public DisableableAppBarLayoutBehavior() {
        super();
        setDragCallback(new DragCallback() {
            @Override
            public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                return false;
            }
        });
    }

    public DisableableAppBarLayoutBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDragCallback(new DragCallback() {
            @Override
            public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                return false;
            }
        });
    }

    public void setEnabled(boolean enabled) {
        setDragCallback(new DragCallback() {
            @Override
            public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                return enabled;
            }
        });
        mEnabled = enabled;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout parent, AppBarLayout child, View directTargetChild, View target, int nestedScrollAxes, int type) {
        return mEnabled && super.onStartNestedScroll(parent, child, directTargetChild, target, nestedScrollAxes, type);
    }
}