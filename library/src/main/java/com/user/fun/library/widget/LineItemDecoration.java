package com.user.fun.library.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.user.fun.library.global.BaseApp;


/**
 * Created by gongxueyong on 2017/4/20.
 * <p>
 * <p>
 * recyclerView的分割线
 */

public class LineItemDecoration extends RecyclerView.ItemDecoration {

    // 分割线的颜色
    @ColorInt
    private int mColor;

    // 分割线的宽度
    protected int mLineWidth;


    /**
     * item 的左, 上, 右, 下, 要不要绘制分割线, 默认值item 下面的分割线
     */
    protected Paint mPaint;


    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

    /**
     * 线值为1dp  颜色为默认的线条颜色
     */
    public LineItemDecoration() {
        this(ContextCompat.getColor(BaseApp.getInstance(), android.R.color.white), 1);
    }

    /**
     * @param color     颜色值
     * @param lineWidth sp 线的宽度
     */
    public LineItemDecoration(@ColorInt int color, int lineWidth) {
        mColor = color;
        mLineWidth = lineWidth;
        init();

    }


    private void init() {
        // 初始化画笔
        mPaint = new Paint();
        mPaint.setColor(mColor);
        mPaint.setStyle(Paint.Style.FILL);
    }



    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (parent.getLayoutManager() instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) parent.getLayoutManager();
            int mOrientation = linearLayoutManager.getOrientation();
            if (mOrientation == HORIZONTAL_LIST)
                drawVerticalLine(c, parent, state);
             else
                drawHorizontalLine(c, parent, state);
        } else
            throw new IllegalArgumentException("LayoutManager invalid Exception");
    }

    public void drawHorizontalLine(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);

            //获得child的布局信息
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + mLineWidth;
            c.drawRect(left, top, right, bottom, mPaint);
            //Log.d("wnw", left + " " + top + " "+right+"   "+bottom+" "+i);
        }
    }


    //画竖线
    public void drawVerticalLine(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);

            //获得child的布局信息
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + mLineWidth;
            c.drawRect(left, top, right, bottom, mPaint);
        }
    }


}
