package com.example.mobilechat;

import android.app.Application;

import com.vondear.rxtools.RxTool;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RxTool.init(this);
    }
}
