package com.am.scheduling.presentation.utils.authentication;


public interface AuthHelper {

    void setSessionToken(String sessionToken);

    String getSessionToken();

    void setRole(String role);

    String getRole();

    void releaseData();

    boolean isLoggedIn();
}
