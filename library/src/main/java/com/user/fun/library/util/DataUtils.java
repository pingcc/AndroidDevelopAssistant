package com.user.fun.library.util;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by gongxueyong on 2017/6/2.
 * 关于时间日期的工具列...  暂时只有时间错转换为日期... 其他有需要在加...
 */

public class DataUtils {


    public static String timeStamp2Date(long seconds) {
        return timeStamp2Date(seconds, null);
    }

    public static String timeStamp2Date(long seconds, String format) {
        if (seconds <= 0)
            return null;
        return timeStamp2Date(new Date(seconds), format);
    }

    public static String timeStamp2Date(Date data, String format) {
        if (data == null)
            return null;

        if (TextUtils.isEmpty(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        return sdf.format(data);
    }

    /*  将时间转换为时间戳*/
    public static long dateToStamp(String s)  {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(s);
            long ts = date.getTime();
            return ts;
        } catch (ParseException e) {
            e.printStackTrace();
        }
      return 0;
    }

    public static String timeStamp2Date(String format) {
        return timeStamp2Date(System.currentTimeMillis(), format);
    }

    public static int[] getCurrentYearMonthDay() {
        Calendar c = Calendar.getInstance();//
        int currentYear = c.get(Calendar.YEAR); // 获取当前年份
        int currentMonth = c.get(Calendar.MONTH) + 1;// 获取当前月份
        int currentDay = c.get(Calendar.DAY_OF_MONTH);// 获取当日期
        return new int[]{currentYear, currentMonth, currentDay};
    }

    /**
     * 计算两个日期型的时间相差多少时间
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return
     */
    public String twoDateDistance(Date startDate, Date endDate) {

        if (startDate == null || endDate == null) {
            return null;
        }
        long timeLong = endDate.getTime() - startDate.getTime();
        if (timeLong < 60 * 1000)
            return timeLong / 1000 + "秒前";
        else if (timeLong < 60 * 60 * 1000) {
            timeLong = timeLong / 1000 / 60;
            return timeLong + "分钟前";
        } else if (timeLong < 60 * 60 * 24 * 1000) {
            timeLong = timeLong / 60 / 60 / 1000;
            return timeLong + "小时前";
        } else if (timeLong < 60 * 60 * 24 * 1000 * 7) {
            timeLong = timeLong / 1000 / 60 / 60 / 24;
            return timeLong + "天前";
        } else if (timeLong < 60 * 60 * 24 * 1000 * 7 * 4) {
            timeLong = timeLong / 1000 / 60 / 60 / 24 / 7;
            return timeLong + "周前";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
            return sdf.format(startDate);
        }
    }

    public static int daysBetween(Date startDate, Date endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            startDate = sdf.parse(sdf.format(startDate));
            endDate = sdf.parse(sdf.format(endDate));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            long time1 = calendar.getTimeInMillis();

            calendar.setTime(endDate);
            long time2 = calendar.getTimeInMillis();
            long betweenDays = (time2 - time1) / (1000 * 3600 * 24);
            return Integer.parseInt(String.valueOf(betweenDays));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static double daysBetweenHours(Date startDate, Date endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            startDate = sdf.parse(sdf.format(startDate));
            endDate = sdf.parse(sdf.format(endDate));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            long time1 = calendar.getTimeInMillis();


            calendar.setTime(endDate);
            long time2 = calendar.getTimeInMillis();
            double betweenDays = (double) (time2 - time1) / (1000 * 3600);

            return Double.parseDouble(String.valueOf(betweenDays));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    public static double daysBetweenMinitus(Date startDate, Date endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            startDate = sdf.parse(sdf.format(startDate));
            endDate = sdf.parse(sdf.format(endDate));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            long time1 = calendar.getTimeInMillis();


            calendar.setTime(endDate);
            long time2 = calendar.getTimeInMillis();
            double betweenDays = (double) (time2 - time1) / (1000 * 60);

            return Double.parseDouble(String.valueOf(betweenDays));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    public static int getDaysOfMonth(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        try {
            Date date = sdf.parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String getFirstAndLastOfWeek(String str) {
        try {
            Calendar cal = Calendar.getInstance();

            cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(str));

            int d = 0;
            if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
                d = -6;
            } else {
                d = 2 - cal.get(Calendar.DAY_OF_WEEK);
            }
            cal.add(Calendar.DAY_OF_WEEK, d);
            // 所在周开始日期
            String data1 = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
            cal.add(Calendar.DAY_OF_WEEK, 6);
            // 所在周结束日期
            String data2 = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
            return data1 + "/" + data2;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}
