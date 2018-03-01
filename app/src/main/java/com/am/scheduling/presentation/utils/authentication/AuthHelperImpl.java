package com.am.scheduling.presentation.utils.authentication;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AuthHelperImpl implements AuthHelper {

    private static final String PREF_SESSION = "session_pref";
    private static final String PREF_SESSION_TOKEN = "session_token";
    private static final String PREF_ROLE = "role";
    private static final String PREF_USER = "user";
    private SharedPreferences mSessionPreferences;


    @Inject
    public AuthHelperImpl(final Context context) {
        mSessionPreferences = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE);
    }

    @Override
    public boolean isLoggedIn() {
        return !TextUtils.isEmpty(getSessionToken());
    }

    @Override
    public void setSessionToken(String sessionToken) {
        mSessionPreferences.edit().putString(PREF_SESSION_TOKEN, sessionToken).apply();
    }

    @Override
    public String getSessionToken() {
        return mSessionPreferences.getString(PREF_SESSION_TOKEN, "");
    }

    @Override
    public void setRole(String role) {
        mSessionPreferences.edit().putString(PREF_ROLE, role).apply();
    }

    @Override
    public String getRole() {
        return mSessionPreferences.getString(PREF_ROLE, "");
    }

    @Override
    public void releaseData() {
        final SharedPreferences.Editor editor = mSessionPreferences.edit();
        editor.clear().apply();
    }
}
