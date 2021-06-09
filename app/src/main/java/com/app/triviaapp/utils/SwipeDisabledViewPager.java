package com.app.triviaapp.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;
// Disabling Viewpager
public class SwipeDisabledViewPager extends ViewPager {
    public SwipeDisabledViewPager(Context context) {
        super(context);
    }

    public SwipeDisabledViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // returning false will not propagate the swipe event
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}