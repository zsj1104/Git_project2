package com.example.h0227.demo2.app;

import android.app.Application;

public class App extends Application {
    public static App app;

    public static App getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
