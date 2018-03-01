package com.am.scheduling.presentation.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public final class DateUtil {

    private DateUtil() {
    }

    public static String getTimeLeft(final int secondsLeft) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, secondsLeft / 60);
        calendar.set(Calendar.SECOND, secondsLeft % 60);
        return new SimpleDateFormat("mm:ss", Locale.US).format(calendar.getTime());
    }
}
