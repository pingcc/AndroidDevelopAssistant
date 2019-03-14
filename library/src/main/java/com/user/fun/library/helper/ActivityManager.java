package com.user.fun.library.helper;

import android.app.Activity;

import java.util.Stack;

/**
 * Created  on 2017/10/16.
 * author  CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */

public class ActivityManager {
    private static Stack<Activity> activityStack;
    private static ActivityManager instance;

    private ActivityManager() {
    }

    public static ActivityManager getActivityManager() {
        if (instance == null) {
            instance = new ActivityManager();
        }
        return instance;
    }

    public void popActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity = null;
        }
    }




    //将当前Activity推入栈中
    public void pushActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    //退出栈中所有Activity
    public void popAllActivityExceptOne() {
        for (Activity activity : activityStack) {
            activity.finish();
        }
        activityStack.clear();
    }
    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public static Activity currentActivity() {
        return activityStack.lastElement();
    }
    //退出栈中除最后一压入的act之外销毁所有Activity
    public void popActivityExceptOne() {
        for (Activity activity : activityStack) {
            if (!activity.getClass().equals(currentActivity().getClass()))
                activity.finish();
        }
    }
}
