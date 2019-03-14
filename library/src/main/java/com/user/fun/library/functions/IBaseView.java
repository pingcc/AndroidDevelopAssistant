package com.user.fun.library.functions;

/**
 * Created on 2017/6/28.
 * author chen_ping
 * Email yy_cping@163.com
 * Edit androidStudio
 */

public interface IBaseView extends ProgressAction, LoadingPageAction, ResponseNetErrorAction {
    void onLoadMoreFail();

    void onRefreshError();

    int onLoadDataSize();

    void onRefreshSuccess();

    void onNoMoreData();
    void onLoadMoreFirstDataEnd();
}
