package com.user.fun.library.functions;

/**
 * Created on 2017/6/28.
 * author chen_ping
 * Email yy_cping@163.com
 * Edit androidStudio
 */

public interface ProgressAction {
    void showProgress(String progressMessage);
    void showProgress(String progressMessage, boolean isCancel);
    void hideProgress();
    void cancelNetRequest();
}
