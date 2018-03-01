package com.am.scheduling.domain.base;

import com.am.scheduling.data.network.exception.Error;
import com.am.scheduling.data.network.exception.HttpError;
import com.am.scheduling.data.network.exception.RetrofitException;

import java.util.List;

import io.reactivex.annotations.NonNull;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public interface ErrorObserver {

    String ERR_UNHANDLED = "E00000";
    String ERR_NOT_FOUND = "E00001";
    String ERR_RESEND_CODE = "E00100";
    String ERR_NOT_FOUND_CODE = "E00101";
    String ERR_INCORRECT_CODE = "E00102";
    String ERR_LREADY_REGISTERED = "E00106";
    String ERR_NOT_REGISTERED = "E00107";

    default void error(@NonNull final Throwable e) {
        e.printStackTrace();
        if (e instanceof RetrofitException) {
            RetrofitException retrofitException = (RetrofitException) e;
            switch (retrofitException.getKind()) {
                case RetrofitException.HTTP:
                    handleHttpError(retrofitException);
                    break;
                case RetrofitException.NETWORK:
                    handleNetworkError();
                    break;
                case RetrofitException.UNEXPECTED:
                    handleUnexpectedError();
                    break;
            }
        }
    }

    default void handleHttpError(final RetrofitException error) {
        switch (error.getResponse().code()) {
            case 400:
                HttpError httpError = error.getErrorBodyAs(HttpError.class);
                if (httpError == null) return;
                handleErrors(httpError.errors);
                break;
            case 504:
                handleNetworkError();
                break;
            case 500:
            default:
                handleUnexpectedError();
                break;
        }
    }

    default void handleNetworkError() {
    }

    default void handleUnexpectedError() {
    }

    default void handleErrors(List<Error> errors) {
        for (Error e : errors) {
            if (ERR_UNHANDLED.equals(e.code))
                handleUnexpectedError();
            else handleError(e);
        }
    }

    default void handleError(Error error) {
    }
}
