package com.user.fun.library.util;

import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created  on 2017/9/25.
 * author  CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */
public class CheckInputUtils {

    /**
     * 监测用户名输入是否合法,
     *
     * @param name 用户名, 企业名称
     * @return 合法 返回 true,  不合法 返回 false
     */
    public static boolean name(String name) {
        return true;
    }

    /**
     * 监测输入框中电话号码是否合法
     * <p>
     * 预留了一个检验香港手机号码的接口, 方便以后扩展
     *
     * @param phoneNum 电话号码
     * @return 合法 返回 true,  不合法 返回 false
     */
    public static boolean phoneNum(String phoneNum) {
        return isChinaPhoneLegal(phoneNum) || isHKPhoneLegal(phoneNum);
    }

    // 香港手机号码, 暂时返回 true, 以后扩展的时候可能会用到
    private static boolean isHKPhoneLegal(String phoneNum) {
        return false;
    }

    // 中国手机号码
    private static boolean isChinaPhoneLegal(String phoneNum) {
        String regExp = "^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-9])|(14[5,6,7,8])||(166)|(19[8,9]))\\d{8}$";
//        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\\\d{8}$";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(phoneNum);
        return matcher.matches();
    }


    /**
     * 监测输入框中密码是否合法
     * 必须同时包含字母数字并且是6-16位
     *
     * @param password 密码
     * @return 合法 返回 true,  不合法 返回 false
     */
    public static boolean password(String password) {
        String regExp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean email(String email) {
        String format = "\\p{Alpha}\\w{2,15}[@][a-z0-9]{3,}[.]\\p{Lower}{2,}";
        //p{Alpha}:内容是必选的，和字母字符[\p{Lower}\p{Upper}]等价。如：200896@163.com不是合法的。
        //w{2,15}: 2~15个[a-zA-Z_0-9]字符；w{}内容是必选的。 如：dyh@152.com是合法的。
        //[a-z0-9]{3,}：至少三个[a-z0-9]字符,[]内的是必选的；如：dyh200896@16.com是不合法的。
        //[.]:'.'号时必选的； 如：dyh200896@163com是不合法的。
        //p{Lower}{2,}小写字母，两个以上。如：dyh200896@163.c是不合法的。
        // 邮箱名合法，返回true
// 邮箱名不合法，返回false
        return email.matches(format);
    }

    /**
     * 监测验证码是否合法
     * 暂时没有要求监测,  留个接口便于以后需要
     *
     * @param smsCode
     * @return
     */
    public static boolean smsCode(String smsCode) {
        return true;
    }

    /**
     * 检查省市区 是否合法
     *
     * @param city
     * @return
     */
    public static boolean city(String city) {
        return true;
    }

    /**
     * 检查公司名称是否合法
     */
    public static boolean companyName(String companyNmae) {
        return true;
    }

    /**
     * 检查身份证号码是否合格
     */
    public static boolean IdCard(String idCardNum) {
        String regExp = "(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(idCardNum);
        return matcher.matches();
    }

    /**
     * 银行卡号码
     */
    public static boolean bankCardNum(String bankCardNum) {
        return true;
    }

    /**
     * 座机电话号码
     */
    public static boolean officeNumber(String officeNum) {
        return Patterns.PHONE.matcher(officeNum).matches();
    }

    /**
     * 地址
     */
    public static boolean urlAddress(String url) {
        return Patterns.WEB_URL.matcher(url).matches();
    }
}
