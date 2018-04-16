package com.example.xqg.weartest.bean;

/**
 * Created by xqg on 2017/9/2.
 */

public class UserInfo {


    private String DeviceId;
    private int statusSitLongCall;
    private int statusCheckMoodCall;
    public static final String tableName = "userinfo";

    public int getStatusCheckMoodCall() {
        return statusCheckMoodCall;
    }

    public void setStatusCheckMoodCall(int statusCheckMoodCall) {
        this.statusCheckMoodCall = statusCheckMoodCall;
    }


    public int getStatusSitLongCall() {
        return statusSitLongCall;
    }

    public void setStatusSitLongCall(int statusSitLongCall) {
        this.statusSitLongCall = statusSitLongCall;
    }
    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String deviceId) {
        DeviceId = deviceId;
    }

}
