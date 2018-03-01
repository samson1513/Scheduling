package com.am.scheduling.data.network.factory;

import android.support.annotation.NonNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public class RxErrorHandlingCallAdapterFactory extends CallAdapter.Factory {
    private final RxJava2CallAdapterFactory original;

    public RxErrorHandlingCallAdapterFactory() {
        original = RxJava2CallAdapterFactory.create();
    }

    /**
     * Returns an {@link RxCallAdapterWrapper} instance
     */
    @Override
    public CallAdapter<?, ?> get(@NonNull Type returnType, @NonNull Annotation[] annotations, @NonNull Retrofit retrofit) {
        return new RxCallAdapterWrapper(retrofit, original.get(returnType, annotations, retrofit));
    }

}
