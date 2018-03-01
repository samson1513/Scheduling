package com.am.scheduling.data.network;

/**
 * Created by Alex Michenko
 * on 07.02.2018.
 */

public interface NetworkConsts {

    String HEADER_TOKEN = "Session-Token";
    int CONNECTION_TIMEOUT = 40;

    String COUNTRIES = "/api/v1/countries";
    String SEND_CODE = "/api/v1/code";
    String LOGIN = "/api/v1/login";
    String LOGOUT = "/api/v1/logout";
}
