package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {

   MediaPlayer mediaPlayer;
    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
    return null;
    }
    // this method is called when the service is started
    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer=MediaPlayer.create(this,R.raw.applemusic);
        mediaPlayer.setLooping(true);//set the music file to loop
        mediaPlayer.setVolume(100,100);

    }
   // when the service is started
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }
    //when the service is destroyed to stop playing the music
    // is we didnt use this method the music will stay also after locking the app
    @Override
    public void onDestroy() {
        //super.onDestroy();
        mediaPlayer.stop();
    }
}