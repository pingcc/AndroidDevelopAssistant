package com.user.fun.library.repository;

/**
 * Created  on 2017/9/27.
 * author  CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */

/**
 * 自定义异常，
 * eg：登陆时验证码错误；参数为传递等
 */
public  class APIException extends Exception {
    public int code;
    public String message;

    public APIException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}