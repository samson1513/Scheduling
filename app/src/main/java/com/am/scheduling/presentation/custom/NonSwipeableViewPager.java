package com.am.scheduling.presentation.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.IntDef;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.am.scheduling.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Alex Michenko
 * on 31.05.2018.
 */
public class NonSwipeableViewPager extends ViewPager {

    @IntDef({NONE, LEFT, RIGHT, ALL})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Direction{}

    public static final int NONE = -1;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int ALL = 2;

    private float initialXValue;
    @Direction
    private int direction;

    public NonSwipeableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NonSwipeableViewPager);

        direction = typedArray.getInteger(R.styleable.NonSwipeableViewPager_swipe_direction, ALL);

        typedArray.recycle();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.IsSwipeAllowed(event)) {
            return super.onTouchEvent(event);
        }

        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.IsSwipeAllowed(event)) {
            return super.onInterceptTouchEvent(event);
        }

        return false;
    }

    private boolean IsSwipeAllowed(MotionEvent event) {
        if(this.direction == ALL) return true;

        if(direction == NONE)//disable any swipe
            return false;

        if(event.getAction()==MotionEvent.ACTION_DOWN) {
            initialXValue = event.getX();
            return true;
        }

        if(event.getAction()== MotionEvent.ACTION_MOVE) {
            try {
                float diffX = event.getX() - initialXValue;
                if (diffX > 0 && direction == RIGHT) {
                    // swipe from left to right detected
                    return false;
                }else if (diffX < 0 && direction == LEFT) {
                    // swipe from right to left detected
                    return false;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        return true;
    }

    public void setAllowedSwipeDirection(@Direction int direction) {
        this.direction = direction;
    }
}
