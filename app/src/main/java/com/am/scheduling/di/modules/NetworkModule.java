package com.am.scheduling.di.modules;

import com.am.scheduling.Config;
import com.am.scheduling.data.network.NetworkConsts;
import com.am.scheduling.data.network.factory.RxErrorHandlingCallAdapterFactory;
import com.am.scheduling.data.services.AuthService;
import com.am.scheduling.presentation.utils.authentication.AuthHelper;
import com.github.aurae.retrofit2.LoganSquareConverterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

@Module
public class NetworkModule {

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient() {
        final OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder()
                .readTimeout(NetworkConsts.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(NetworkConsts.CONNECTION_TIMEOUT, TimeUnit.SECONDS);

        Config.addInterceptors(okHttpBuilder);

        return okHttpBuilder.build();
    }

    @Named("BaseRetrofit")
    @Singleton
    @Provides
    Retrofit provideBaseRetrofit(final OkHttpClient okHttpClient, final AuthHelper authHelper) {
        okHttpClient.newBuilder()
                .addInterceptor(chain -> chain.proceed(chain.request().newBuilder()
                        .header(NetworkConsts.HEADER_TOKEN, authHelper.getSessionToken())
                        .build()));
        return new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(LoganSquareConverterFactory.create())
                .addCallAdapterFactory(new RxErrorHandlingCallAdapterFactory())
                .build();
    }

    @Named("AuthRetrofit")
    @Singleton
    @Provides
    Retrofit provideAuthRetrofit(final OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(LoganSquareConverterFactory.create())
                .addCallAdapterFactory(new RxErrorHandlingCallAdapterFactory())
                .build();
    }

    @Singleton
    @Provides
    AuthService provideAuthService(@Named("AuthRetrofit") Retrofit retrofit) {
        return retrofit.create(AuthService.class);
    }
}
