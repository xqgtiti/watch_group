package com.example.xqg.weartest.bean;

import android.app.Application;

/**
 * Created by xqg on 2017/9/2.
 */

public class Data extends Application {

    UserInfo userInfo;
    Mood mood;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public SystemData getSystemData() {
        return systemData;
    }

    public void setSystemData(SystemData systemData) {
        this.systemData = systemData;
    }

    SystemData systemData;


}
