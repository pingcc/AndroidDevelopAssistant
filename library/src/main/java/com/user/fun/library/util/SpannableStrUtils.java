package com.user.fun.library.util;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;


/**
 * Created  on 2017/9/27.
 * author  CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */

public class SpannableStrUtils {

    /**
     * 将普通文本中的一部分文字转换为红色...
     *
     * @param source 要转换的源文本
     * @param start  要转换的开始的位置
     * @param end    要转换的结束的位置,  如果end < 0,  则 end 为所有文本的长度,  即整段文本的结尾...
     * @return
     */
    public static SpannableString getColorSpanStr(SpannableString source, int color, int start, int end) {

        if (TextUtils.isEmpty(source))
            return null;

        if (end < 0) end = source.length();

        source.setSpan(
                new ForegroundColorSpan(color),
                start, end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return source;
    }
    public static SpannableString setTextSize(SpannableString source, int textSize, int start, int end) {
        if (TextUtils.isEmpty(source))
            return null;

        if (end < 0) end = source.length();

        source.setSpan(new AbsoluteSizeSpan(textSize),
                start, end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return source;
    }
}
