package com.user.fun.library.util;

import android.util.Log;

import com.user.fun.library.BuildConfig;

/**
 * Created  on 2019/3/12.
 *
 * @author CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */
public class LogUtils {
    private static boolean isLog = BuildConfig.DEBUG;

    public static void i(String Tag, String msg) {
        if (isLog)
            Log.i(Tag, msg);
    }
    public static void d(String Tag, String msg) {
        if (isLog)
            Log.d(Tag, msg);
    }
    public static void e(String Tag, String msg) {
        if (isLog)
            Log.e(Tag, msg);
    }
}
