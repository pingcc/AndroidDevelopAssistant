package com.user.fun.library.functions;

/**
 * Created on 2017/7/11.
 * author chen_ping
 * Email yy_cping@163.com
 * Edit androidStudio
 */

public interface ResponseNetErrorAction {
    void  onResponseError(int resultCode, String tip);//响应的结果码，提示信息，用于验证oken
    void  onNetError(String errorMsg); //网络失败的异常信息
}
