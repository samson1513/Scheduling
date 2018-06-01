package com.am.scheduling.presentation.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public final class DateUtil {

    private DateUtil() {
    }
    public static final String PATTERN_SERVER_DATE = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String PATTERN_TIMESTAMP = "yyyy_MM_dd_HH_mm_ss";
    public static final String PATTERN_TIME = "HH:mm";
    public static final String PATTERN_DATE = "dd.MM";
    public static final String PATTERN_WEEK_DAY = "EE";
    public static final String PATTERN_WEEK_DAY_TIME = "EE HH:mm";

    public static String toString(Date date, String pattern) {
        return toString(date, pattern, false);
    }

    public static String toString(Date date, String pattern, boolean toUtc) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
        if (toUtc) {
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }
        return dateFormat.format(date);
    }

    public static Date toDate(String dateStr, String pattern) {
        return toDate(dateStr, pattern, false);
    }

    public static Date toDate(String serverDate, String pattern, boolean fromUtc) {
        Date startDate = new Date();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
            if (fromUtc) {
                dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            }
            startDate = dateFormat.parse(serverDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return startDate;
    }

    public static String getTimeLeft(final int secondsLeft) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, secondsLeft / 60);
        calendar.set(Calendar.SECOND, secondsLeft % 60);
        return new SimpleDateFormat("mm:ss", Locale.US).format(calendar.getTime());
    }
}
