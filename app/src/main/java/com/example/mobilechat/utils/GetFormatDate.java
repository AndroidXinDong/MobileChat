package com.example.mobilechat.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Cool on 2016/8/22.
 */
public class GetFormatDate {
    /**
     * 将数字时间转化成长日期
     *
     * @param dateTime
     * @return
     */
    public static String getFormatedDateTime(long dateTime) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(dateTime);
        return sDateFormat.format(date);
    }

    /**
     * 将数字时间转化成短日期
     *
     * @param dateTime
     * @return
     */
    public static String getFormatedDate(long dateTime) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(dateTime);
        return sDateFormat.format(date);
    }

    /**
     * 将日期转化成数字时间
     *
     * @param time
     * @return
     */
    public static long getTime(String time) {
        long longTime = 0;
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sDateFormat.parse(time);
            longTime = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return longTime;
    }
}
