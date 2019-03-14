package com.user.fun.library.functions;

import android.support.annotation.NonNull;

/**
 * Created on 2017/6/29.
 * author chen_ping
 * Email yy_cping@163.com
 * Edit androidStudio
 */

public interface Presenter {
    void onCreate();

    void attachView(@NonNull IBaseView view);

    void onResume();

    void onPause();

    void onDestroy();
}
