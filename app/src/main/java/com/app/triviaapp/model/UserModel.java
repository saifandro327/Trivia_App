package com.app.triviaapp.model;

import android.text.TextUtils;

public class UserModel implements Userinterface {


    private String userName;

    public UserModel(String userName) {
        this.userName = userName;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public int isValid() {
        if (TextUtils.isEmpty(getUsername())) {
            return 0;
        }
    return -1;
    }
}
