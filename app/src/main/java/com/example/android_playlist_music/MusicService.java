package com.example.android_playlist_music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MusicService extends Service {

    MediaPlayer mp;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }


    @Override
    public void onCreate() {
       Toast.makeText(this, "Service đã được tạo!", Toast.LENGTH_SHORT).show();
         //   mp = MediaPlayer.create(this,R.raw.gangnamstyle);

        mp = MediaPlayer.create(this, R.raw.ht);
        mp.setLooping(false);
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service đã bị hủy!", Toast.LENGTH_SHORT).show();
        mp.stop();

    }
    public boolean play(){
        mp.start();
//        mp.setLooping(true);

        return mp.isPlaying();
    }

    public boolean pause(){
        mp.pause();
        return !mp.isPlaying();
    }
    public class MyBinder extends Binder {
        public MusicService getService() {
            return MusicService.this;
        }
    }

}
