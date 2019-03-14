package com.user.fun.library.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.Toast;

import com.user.fun.library.global.BaseApp;

/**
 * Created on 2017/6/26.
 * author chen_ping
 * Email yy_cping@163.com
 * Edit androidStudio
 */

public class UiUtils {
    public static final Context mContext = BaseApp.getInstance();

    public static int getColor(int colorId) {
        return ContextCompat.getColor(mContext, colorId);
    }

    public static Drawable getDrawable(int drawableId) {
        return ContextCompat.getDrawable(mContext, drawableId);
    }


    @NonNull
    public static String getString(int stringId) {
        return mContext.getResources().getString(stringId);
    }

    //加载字符串
    @NonNull
    public static String[] getStringArray(int id) {
        return  mContext.getResources().getStringArray(id);
    }

    //加载颜色的状态选择器
    @NonNull
    public static ColorStateList getColorStateList(int id) {
        return ContextCompat.getColorStateList(mContext, id);
    }

    /**
     * dp转px
     */
    public static float dp2px(float value) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getDisplayMetrics());
    }


    public static float px2dip(int px) {
        float density = mContext.getResources().getDisplayMetrics().density;// 设备密度
        return px / density;
    }

    /**
     * sp转px
     */
    public static float sp2px(float value) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value, getDisplayMetrics());
    }

    /**
     * 获取屏幕信息
     */
    public static DisplayMetrics getDisplayMetrics() {
        return Resources.getSystem().getDisplayMetrics();
    }

    /*获取屏幕的宽*/
    public static int getScreenWidth() {
        return getDisplayMetrics().widthPixels;
    }

    /*获取屏幕的高*/
    public static int getScreenHeight() {
        return getDisplayMetrics().heightPixels;
    }

    /*显示toast的*/
    public static void showToast(String text) {
        Toast toast = Toast.makeText(mContext, text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /*显示toast的*/
    public static void showToast(int resId) {
        Toast toast = Toast.makeText(mContext, getString(resId), Toast
                .LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
    public static int getStatusBarHeight() {
        return Resources.getSystem().getDimensionPixelSize(
                Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
    }
    /**
     * 判断当下是否在主线程中执行
     */
    public static boolean isRunInMainThread() {
        int currentThreadId = android.os.Process.myTid();
        return currentThreadId == BaseApp.getMainThreadId();
    }


}
