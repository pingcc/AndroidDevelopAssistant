package com.user.fun.library.functions;

/**
 * Created  on 2017/9/27.
 * author  CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */

public interface ResponseDataError {
    void onNext(int resultCode, String tip);//错误的请求处理方案
}
