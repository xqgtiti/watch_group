package com.example.xqg.weartest.bean;

/**
 * Created by xqg on 2017/9/2.
 */

public class Mood {
    private int timestamp;

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getMoodType() {
        return moodType;
    }

    public void setMoodType(int moodType) {
        this.moodType = moodType;
    }

    private int moodType;
}
