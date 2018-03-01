package com.am.scheduling.data.network.exception;

import android.support.annotation.IntDef;

import com.bluelinelabs.logansquare.LoganSquare;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public class RetrofitException extends RuntimeException {

    @IntDef({HTTP, NETWORK, UNEXPECTED})
    @Retention(RetentionPolicy.RUNTIME)
    @interface Kind {
    }

    public static final int HTTP = 0;
    public static final int NETWORK = 1;
    public static final int UNEXPECTED = 2;

    /**
     * Returns exception associated with HTTP, something like INTERNAL_SERVER_ERROR or other.
     *
     * @param url      The url which has a mistake
     * @param response The data returned from the API
     * @param retrofit See {@link Retrofit}
     */
    public static RetrofitException httpError(String url, Response response, Retrofit retrofit) {
        String message = response.code() + " " + response.message();
        return new RetrofitException(message, url, response, HTTP, null, retrofit);
    }

    /**
     * Returns exception associated with network, something like TimeoutException or other.
     *
     * @param exception The exception that arise between client and server
     */
    public static RetrofitException networkError(IOException exception) {
        return new RetrofitException(exception.getMessage(), null, null, NETWORK, exception, null);
    }

    /**
     * Returns exception associated with an application internal error.
     *
     * @param exception Unknown to us exception
     */
    public static RetrofitException unexpectedError(Throwable exception) {
        return new RetrofitException(exception.getMessage(), null, null, UNEXPECTED, exception, null);
    }

    private final String url;
    private final Response response;
    @Kind
    private final int kind;
    private final Retrofit retrofit;

    private RetrofitException(String message, String url, Response response, @Kind int kind, Throwable exception, Retrofit retrofit) {
        super(message, exception);
        this.url = url;
        this.response = response;
        this.kind = kind;
        this.retrofit = retrofit;
    }

    /**
     * The request URL which produced the error.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Response object containing status code, headers, body, etc.
     */
    public Response getResponse() {
        return response;
    }

    /**
     * The event kind which triggered this error.
     */
    @Kind
    public int getKind() {
        return kind;
    }

    /**
     * The Retrofit this request was executed on
     */
    public Retrofit getRetrofit() {
        return retrofit;
    }

    public <T> T getErrorBodyAs(Class<T> type) {
        if (response == null) {
            return null;
        } else {
            try {
                ResponseBody responseBody = response.errorBody();
                if (responseBody != null) {
                    String body = responseBody.string();
                    return LoganSquare.parse(body, type);
                } else {
                    return null;
                }
            } catch (IOException e) {
                return null;
            }
        }
    }
}
