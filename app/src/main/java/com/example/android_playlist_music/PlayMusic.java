package com.example.android_playlist_music;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayMusic extends AppCompatActivity {
    private ImageView imgHinhPlay;
    private ImageView btnStop;
    private ImageView btnPlay;
    private ImageView btnBack;
    private TextView txtNamePlay;
    private TextView txtSingerPlay;
    private MusicService musicService;
    private boolean isBound = false;
    private ServiceConnection connection;
    private ServiceConnection serviceConnection;

    private boolean isConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        String txtName= getIntent().getStringExtra("txtName");
        String txtSinger= getIntent().getStringExtra("txtSinger");
        int imgHinh= getIntent().getIntExtra("imgHinh",2);

        imgHinhPlay=findViewById(R.id.imgHinhPlay);
        txtNamePlay=findViewById(R.id.txtNamePlay);
        txtSingerPlay=findViewById(R.id.txtSingerPlay);
        btnStop=findViewById(R.id.btnStop);
        btnPlay=findViewById(R.id.btnPlay);
        btnBack=findViewById(R.id.btnBack1);

        imgHinhPlay.setImageResource(imgHinh);
        txtNamePlay.setText(txtName);
        txtSingerPlay.setText(txtSinger);

        Fade fade = new Fade();
        View decor= getWindow().getDecorView();

        getWindow().setEnterTransition(fade);

        getWindow().setExitTransition(fade);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicService.onDestroy();
                Intent intent = new Intent(PlayMusic.this,MainActivity.class);

                ActivityOptionsCompat optionsCompat=ActivityOptionsCompat.makeSceneTransitionAnimation(
                        PlayMusic.this,imgHinhPlay,
                        ViewCompat.getTransitionName(imgHinhPlay)
                );
                startActivity(intent, optionsCompat.toBundle());
            }
        });
        musicService= new MusicService();

        connectService();
        musicService= new MusicService();
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isConnected){
                    return;
                }
                Toast.makeText(PlayMusic.this, "name +" +txtNamePlay.getText().toString(), Toast.LENGTH_LONG).show();
                musicService.play();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isConnected){
                    return;
                }
                musicService.pause();
            }
        });
    }

    private void connectService() {

        Intent intent = new Intent(this, MusicService.class);

        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                MusicService.MyBinder myBinder = (MusicService.MyBinder) service;

                musicService = myBinder.getService();

                isConnected = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                isConnected = false;
                musicService = null;
            }
        };
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }
}