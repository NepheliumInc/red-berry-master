package com.redberry.mvc.model;

/**
 * Created by kokila on 7/17/15.
 */
public class Auth {
    public enum userRoll {
        ADMIN, GUEST, FOM, CLEANING_STAFF
    }

    private boolean authenticated;
    private int authId;
    private userRoll userRoll;


    public Auth(boolean authenticated, int authId, userRoll userRoll) {
        this.authenticated = authenticated;
        this.authId = authId;
        this.userRoll = userRoll;
    }

    public Auth(boolean authenticated, int authId) {
        this.authenticated = authenticated;
        this.authId = authId;
    }

    public Auth(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }

    public userRoll getUserRoll() {
        return userRoll;
    }

    public void setUserRoll(userRoll userRoll) {
        this.userRoll = userRoll;
    }
}
