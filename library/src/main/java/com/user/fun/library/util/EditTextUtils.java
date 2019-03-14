package com.user.fun.library.util;

import android.text.InputFilter;
import android.text.TextUtils;
import android.widget.EditText;

import com.user.fun.library.config.Constants;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mac on 2017/5/12.
 */

public class EditTextUtils {



    /**
     * 价格输入框输入设置
     *
     * @param et : 被设置的  EditText 对象
     */
    public static void priceETSetting(EditText et) {

        et.setLongClickable(false);   //不能复制,粘贴

        et.setFilters(new InputFilter[]{(source, start, end, dest, dstart, dend) -> {
            String text = dest.toString();
            int textLength = text.length();


            if (TextUtils.equals("", source)) {   //这是删除
                    String deleteChar = text.substring(dstart, dend);
                    if (TextUtils.equals(".", deleteChar)) {   //删除的是 .
                        if (textLength - 1 > 4 && textLength > dend) {
                            return ".";
                        }
                    }
                /*   这操作剪切会报错
                 if (dstart == 0 && textLength > 1) {//删除的是第一位
                        String deleteNextChar = text.substring(dstart + 1, dend + 1);//下一位
                        if (TextUtils.equals(".", deleteNextChar)) {   //删除的是 0  后面.
                            return "0";
                        }
                    }*/



            }


            if (source.equals(".")) {

                if (dstart == 0) {
                    return "0.";
                }


                if (textLength - dend > 2) {
                    return "";
                }

                if (!text.contains(".")) {
                    return null;
                }

            }
            if (text.contains(".")) {
                int index = text.indexOf(".");

                if (textLength - index <= 2 && dstart > index) {   //小数点后面也可以写数字
                    return null;
                }


                int length = text.substring(index).length();
                if (length == 3 && dstart > index) {
                    return "";
                }

                /*if (index >= 4) {
                    return "";
                }*/

            } /*else {
                if (text.length() >= 4) {
                    return "";
                }
            }*/
            //第一位不能添加0
            if (source.equals("0") && dstart == 0 && textLength > 0) {
                return "";
            }

            //第一位为0,第二位不能添加0
            if (source.equals("0") && dstart == 1 && text.startsWith("0")) {
                return "";
            }


            return null;
        }});
    }

    /**
     * 数量输入框输入设置
     */
    public static void numberETSetting(EditText et) {

        et.setLongClickable(false);   //不能复制,粘贴

        et.setFilters(new InputFilter[]{(source, start, end, dest, dstart, dend) -> {
            String text = dest.toString();
            int textLength = text.length();
            if (source.length() + textLength > 4) {
                return source.subSequence(0, 4 - textLength);
            }

            //不能有.
            if (source.equals(".")) {
                return "";
            }
            //第一位不能添加0
            if (source.equals("0") && dstart == 0) {
                return "";
            }
            if (text.length() >= 4) {
                return "";
            }

            return null;
        }});
    }

    /**
     * 数量输入框输入设置,可以输入0
     */
    public static void numberETZeroSetting(EditText et) {

        et.setLongClickable(false);   //不能复制,粘贴

        et.setFilters(new InputFilter[]{(source, start, end, dest, dstart, dend) -> {
            String text = dest.toString();
            int textLength = text.length();
            if (source.length() + textLength > 4) {
                return source.subSequence(0, 4 - textLength);
            }

            //不能有.
            if (source.equals(".")) {
                return "";
            }
            //第一位为0
            if (dstart == 0 && source.equals("0")) {
                if (dstart == 1)//第二位不能再输
                    return "";
            }
            if (text.length() >= 4) {
                return "";
            }

            return null;
        }});
    }

    /**
     * 数量输入框输入设置 ,可输入负数
     */
    public static void numberNegativeETSetting(EditText et) {

        et.setLongClickable(false);   //不能复制,粘贴

        et.setFilters(new InputFilter[]{(source, start, end, dest, dstart, dend) -> {
            String text = dest.toString();
            int textLength = text.length();
            if (source.length() + textLength > 4) {
                return source.subSequence(0, 4 - textLength);
            }


            //不能有.
            if (source.equals(".")) {
                return "";
            }
            //第一位为0
            if (dstart == 0 && source.equals("0")) {
                if (dstart == 1)//第二位不能再输
                    return "";
            }
            if (textLength > 0) {//长度大于0，第一位不能输入0
                if (dstart == 0 && source.equals("0"))
                    return "";
            }
            if (text.contains("-")) {//如果是负数
                if (dstart == 1 && source.equals("0"))//第二位不能输入0
                    return "";
            }


            if (text.length() >= 4) {
                return "";
            }

            return null;
        }});
    }

    /**
     * 发货输入快递单号
     */
    public static void numberTextETSetting(EditText et) {
        et.setFilters(new InputFilter[]{(source, start, end, dest, dstart, dend) -> {
            String text = dest.toString();
            if (text.length() > 20)
                return "";


            String regExp = "^[A-Za-z0-9]$";
            Pattern pattern = Pattern.compile(regExp);
            Matcher matcher = pattern.matcher(source);
            if (!matcher.matches()) {
                return "";
            }

            return null;
        }});
    }

    /**
     * 身份证验证
     */
    public static void idCardETSetting(EditText et) {
        et.setFilters(new InputFilter[]{(source, start, end, dest, dstart, dend) -> {
            if (source.length() > 1) {
                return null;
            }

            String text = dest.toString();
            if (text.length() >= Constants.ID_CARD_LENGTH)
                return "";

            String regExp;
            if (text.length() == Constants.ID_CARD_LENGTH - 1) {
                regExp = "^[0-9x]$";
            } else {
                regExp = "^[0-9]$";
            }

            Pattern pattern = Pattern.compile(regExp);
            Matcher matcher = pattern.matcher(source);
            if (!matcher.matches()) {
                return "";
            }

            return null;
        }});
    }

    /**
     * 打折输入框输入设置
     * 最大为9.9
     */
    public static void discountETSetting(EditText et) {
        et.setFilters(new InputFilter[]{(source, start, end, dest, dstart, dend) -> {
            String text = dest.toString();
            if (TextUtils.equals("", source)) {   //这是删除
                String deleteChar = text.substring(dstart, dend);
                if (TextUtils.equals(".", deleteChar)) {   //删除的是 .
                    if (text.length() > dend)
                        return ".";
                }
            }
            if (text.contains(".")) {
                int index = text.indexOf(".");
                int length = text.substring(index).length();
                if (length == 2 && dstart > index) {//小数点后面1位
                    return "";
                }
            }
            if (text.length() > 2)//最多输入两位
                return "";
            if (dstart == 0 && source.equals(".")) //判断第一位输入.
                return "";
            if ((dstart == 1) && !source.equals("."))//第二位不等于.
                return "";
            if ((dstart == 2) && source.equals("."))//第三位等于.
                return "";
            if (dstart > 2) //大于三位
                return "";
            return null;//可以返回
        }});
    }
}
