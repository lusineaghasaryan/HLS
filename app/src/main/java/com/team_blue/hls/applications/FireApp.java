package com.team_blue.hls.applications;


import android.app.Application;

import com.firebase.client.Firebase;



public class FireApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

       Firebase.setAndroidContext(this);
    }
}
