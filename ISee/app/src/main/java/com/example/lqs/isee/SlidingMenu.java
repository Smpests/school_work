package com.example.lqs.isee;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by qingsong on 2017/9/26.
 */

public class SlidingMenu extends HorizontalScrollView {
    //屏幕宽度
    private int mScreenWidth;
    //侧滑界面右边距
    private int mMenuRightPadding = 0;
    private int mHalfScreenWidth;
    private boolean once;
    private WordsFragment wordsFragment;

    public SlidingMenu(Context context, AttributeSet attrs) {
        super(context,attrs);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        mScreenWidth = dm.widthPixels;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!once) {
            LinearLayout wrapper = (LinearLayout) getChildAt(0);
            ViewGroup menu = (ViewGroup) wrapper.getChildAt(0);
            ViewGroup content = (ViewGroup) wrapper.getChildAt(1);
            //dp to px
            mMenuRightPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    mMenuRightPadding,content.getResources().getDisplayMetrics());
            mHalfScreenWidth = mScreenWidth / 2;
            menu.getLayoutParams().width = mScreenWidth;
            content.getLayoutParams().width = mScreenWidth;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            //将菜单隐藏
            this.scrollTo(mScreenWidth,0);
            once = true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch(action) {
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();
                if (scrollX > mHalfScreenWidth) {
                    this.smoothScrollTo(mScreenWidth, 0);
                }
                else {
                    this.smoothScrollTo(0, 0);
                    wordsFragment.refreshList();
                }
                return true;
        }
        return super.onTouchEvent(ev);
    }

    public String getLayoutMessages() {
        return "屏幕:" + mScreenWidth + " 滑窗:" + " HALF:" + mScreenWidth + "右边距:" + mMenuRightPadding;
    }
    public void setWordsFragment(WordsFragment wordsFragment) {
        this.wordsFragment = wordsFragment;
    }
}
