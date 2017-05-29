package com.example.android.quakereport;

import android.app.Activity;

public class Quake extends Activity {

    private double mMag;
    private String mLocation;
    private long mDate;
    private String mUrl;

    public Quake(double mag, String location, long date, String url) {
        mMag = mag;
        mLocation = location;
        mDate = date;
        mUrl = url;
    }

    public double getmMag() {
        return mMag;
    }

    public String getmLocation() {
        return mLocation;
    }

    public long getmDate() {
        return mDate;
    }

    public String getmUrl() {
        return mUrl;
    }
}
