package com.app.easynavigationbar.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

import com.daimajia.androidanimations.library.flippers.FlipInXAnimator;

/**
 * ***********************************************
 * **            佛祖保佑  镇类之宝              **
 * ***********************************************
 *
 * @author ziker
 * @date 2021/6/1 10:26
 * @description 新的
 **/
public class CustomViewPager extends ViewPager {

    private boolean isCanScroll = true;
    private boolean test = false;

    public CustomViewPager(Context context) {
        super(context);
        FlipInXAnimator flip = new FlipInXAnimator();
        flip.prepare(this);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCanScroll(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isCanScroll && super.onInterceptTouchEvent(ev);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isCanScroll && super.onTouchEvent(ev);
    }
}