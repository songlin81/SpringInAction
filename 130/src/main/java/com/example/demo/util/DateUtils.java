package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private final static long minute = 60 * 1000;
    private final static long hour = 60 * minute;
    private final static long day = 24 * hour;
    private final static long month = 31 * day;
    private final static long year = 12 * month;

    public final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmssSSS";

    public static String getDateSequence() {
        return new SimpleDateFormat(YYYYMMDDHHMMSS).format(new Date());
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public static String getTimeFormatText(Long date) {
        if (date == null) {
            return null;
        }
        long diff = new Date().getTime() - date;
        long r = 0;
        if (diff > year) {
            r = (diff / year);
            return r + "year ago";
        }
        if (diff > month) {
            r = (diff / month);
            return r + "month ago";
        }
        if (diff > day) {
            r = (diff / day);
            return r + "day ago";
        }
        if (diff > hour) {
            r = (diff / hour);
            return r + "hour ago";
        }
        if (diff > minute) {
            r = (diff / minute);
            return r + "minute ago";
        }
        return "just now";
    }

    public static long getDayBegin(long timestamp) {
        String format = "yyyy-MM-DD";
        String toDayString = new SimpleDateFormat(format).format(new Date(timestamp));
        Date toDay = null;
        try {
            toDay = org.apache.commons.lang3.time.DateUtils.parseDate(toDayString, new String[]{format});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return toDay.getTime();
    }

    public static long getLastMonthTime() {
        return getDayBegin(getCurrentTime())-86400000l*30;
    }
}