package com.am.scheduling.presentation.utils;

import android.support.annotation.IntDef;
import android.text.TextUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Pattern;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public final class Validator {

    @IntDef({OK, INVALID, EMPTY})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Status{}

    public final static int OK = 1;
    public final static int INVALID = 0;
    public final static int EMPTY = 2;

    private static final Pattern regExName = Pattern.compile("^([a-zA-Z'\\-]){3,30}$");   //3-30, lower, upper, apostrophe, hyphen
    private static final Pattern regExPhone = Pattern.compile("^([0-9]){7,15}$");   //7-15, digits

    @Status
    public static int isCorrectPhone(final String phone) {
        if (TextUtils.isEmpty(phone)) {
            return EMPTY;
        } else {
            return regExPhone.matcher(phone).matches() ? OK : INVALID;
        }
    }

    @Status
    public static int isCorrectName(final String name) {
        if (TextUtils.isEmpty(name)) {
            return EMPTY;
        } else {
            return regExName.matcher(name).matches() ? OK : INVALID;
        }
    }

    @Status
    public static int isCorrectCode(final String code) {
        if (TextUtils.isEmpty(code)) {
            return EMPTY;
        } else {
            return code.length() == 4 ? OK : INVALID;
        }
    }

}
