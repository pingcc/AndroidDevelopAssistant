/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.user.fun.library.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;


/**
 * Created on 2017/7/17.
 * author chen_ping
 * Email yy_cping@163.com
 * Edit androidStudio
 * Toast工具类，解决多个Toast同时出现的问题
 */

public class ToastUtils {

    private static Toast mToast;
    private static Context context = UiUtils.mContext;

    /********************** 非连续弹出的Toast ***********************/
    public static void showSingleToast(int resId) { //R.string.**
        showSingleToast(UiUtils.getString(resId));
    }

    public static void showSingleToast(String text) {
        if (TextUtils.isEmpty(text))
            return;
        Toast toast = getSingleToast(text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }


    public static Toast getSingleToast(String text, int duration) {

        if (mToast == null) {
            mToast = Toast.makeText(context, text, duration);
        } else {
            mToast.setText(text);
        }
        return mToast;
    }

    /*********************** 连续弹出的Toast ************************/
    public static void showToast(int resId) {
        showToast(UiUtils.getString(resId));
    }

    public static void showToast(String text) {
        if (TextUtils.isEmpty(text))
            return;
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }


}
