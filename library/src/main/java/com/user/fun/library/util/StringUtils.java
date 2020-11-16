package com.user.fun.library.util;

import android.text.TextUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.text.TextUtils.isEmpty;

/**
 * String Utils
 *
 * @author Trinea 2011-7-22
 */
public class StringUtils {

    /**
     * encoded in utf-8, if exception, return defultReturn
     *
     * @param str
     * @param defultReturn
     * @return
     */
    public static String utf8Encode(String str, String defultReturn) {
        if (!isEmpty(str) && str.getBytes().length != str.length()) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                return defultReturn;
            }
        }
        return str;
    }


    public static String str = "";


    public static int StringParseInt(String s) {
        try {
            int a = Integer.parseInt(s);
            return a;
        } catch (NumberFormatException e) {

            e.printStackTrace();
        }
        return 0;
    }

    public static long StringParseLong(String s) {
        try {
            long a = Long.parseLong(s);
            return a;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Double StringParseDouble(String s) {
        if (s.equals("."))
            return 0d;
        if (!TextUtils.isEmpty(s)) {
            try {
                double a = Double.valueOf(s);
                return a;
            } catch (NumberFormatException e) {

                e.printStackTrace();
            }
        }
        return null;
    }

    public static String add_4Char(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int aLen = ((str.length()) % 4 == 0) ? str.length() / 4 : str.length() / 4 + 1;
        String[] a = new String[aLen];
        String result = "";
        for (int i = 0; i < aLen; i++) {
            int begin = i * 4;
            int end = (i * 4 + 4) > str.length() ? str.length() : i * 4 + 4;
            a[i] = str.substring(begin, end);
        }
        for (int i = 0; i < aLen; i++) {
            result = result + a[i] + " ";
        }
        return result;
    }


    /**
     * 解析 url 中的参数  返回一个 包含 get url 中的参数键值对( 都是用 String 的形式保存)
     *
     * @param url
     * @return 都是用 String 保存的键值对 的 map 集合
     */
    public static Map<String, String> getUrlParameter(String url) {

        Map<String, String> result = new HashMap<>();

        String[] pathAndParam = url.split("\\?");

        if (pathAndParam.length <= 1)
            return null;

        String param = pathAndParam[1];

        String[] params = param.split("&");

        for (String s : params) {
            String[] quay = s.split("=");
            if (quay.length <= 1)
                break;

            result.put(quay[0], quay[1]);
        }

        return result;
    }

    /**
     * String 转 list
     */
    public static List<String> strParseList(String str, String character) {
        if (isEmpty(character)) {
            return null;
        }
        String[] strs = str.split(character);

        return Arrays.asList(strs);
    }

}
