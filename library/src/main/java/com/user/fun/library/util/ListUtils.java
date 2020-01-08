package com.user.fun.library.util;

import android.os.Build;

import java.util.ArrayList;
import java.util.List;

/**
 * Created  on 2020/1/8.
 *
 * @author CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */
public class ListUtils {

    public static void main(String[] args){
        ArrayList list = new ArrayList<>();
        list.add("w");
        list.add("w");
        list.add("w");

        System.out.print(ListUtils.listParseStr(list,"-"));
    }
    /**
     * list转string
     */

    public static  CharSequence listParseStr(List<CharSequence> list, String character) {
        if (list == null || list.size() == 0) {
            return null;
        }
        String str = "";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            str = String.join(character, list);
        } else {
            for (CharSequence item : list) {
                str += item + character;
            }
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

}
