package com.example.myapplication;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    //this class is intiated when a braodcast
    public void onReceive(Context context, Intent intent) {
        Intent intent1=new Intent(context, NotificationIntentService.class);
        context.startService(intent1);


    }
}
