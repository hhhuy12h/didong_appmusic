package com.example.android_playlist_music;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MusicAdapter musicAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Music> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList= new ArrayList<>();

            arrayList.add(new Music(R.drawable.hetnhac_1,"Het nhac con ve ","RZ Max"));
            arrayList.add(new Music(R.drawable.hetnhac_1,"Het nhac con ve 1","RZ Max"));
            arrayList.add(new Music(R.drawable.hetnhac_1,"Het nhac con ve 2","RZ Max"));
            arrayList.add(new Music(R.drawable.hetnhac_1,"Het nhac con ve 3","RZ Max"));
            arrayList.add(new Music(R.drawable.hetnhac_1,"Het nhac con ve 4","RZ Max"));
            arrayList.add(new Music(R.drawable.hetnhac_1,"Het nhac con ve 5","RZ Max"));


        recyclerView=findViewById(R.id.recyclerView);
        musicAdapter=new MusicAdapter(arrayList,this);
        recyclerView.setAdapter(musicAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        GridLayoutManager layoutManager= new GridLayoutManager(MainActivity.this,1,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

    }
}