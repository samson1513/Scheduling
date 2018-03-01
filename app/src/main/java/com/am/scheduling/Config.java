package com.am.scheduling;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

/**
 * Created by Alex Michenko
 * on 24.02.2018.
 */

public class Config {

    public final static String AUTHORITY = "31.131.16.243:91";
    public final static String BASE_URL = "http://" + AUTHORITY;

    private Config() {

    }

    public static void init(Application application) {
        Stetho.initializeWithDefaults(application);
    }

    public static void addInterceptors(OkHttpClient.Builder builder) {
        builder.addNetworkInterceptor(new StethoInterceptor());
    }

}
