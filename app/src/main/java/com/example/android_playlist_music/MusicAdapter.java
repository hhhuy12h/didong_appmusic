package com.example.android_playlist_music;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {
    private ArrayList<Music> musicArrayList;
    private LayoutInflater layoutInflater;
    private Context context;

    @NonNull
    @Override
    public MusicAdapter.MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.from(parent.getContext()).inflate(R.layout.music_list,parent,false);
        MusicViewHolder mvh= new MusicViewHolder(view);
        return mvh;
    }

    public MusicAdapter(ArrayList<Music> musicArrayList, Context context) {
        layoutInflater=LayoutInflater.from(context);
        this.musicArrayList = musicArrayList;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdapter.MusicViewHolder holder, int position) {
        Music music= musicArrayList.get(position);
        holder.txtSinger.setText(music.getTxtSinger());
        holder.txtName.setText(music.getTxtName());
        holder.imgHinh.setImageResource(music.getImgHinh());
    }

    @Override
    public int getItemCount() {
        return musicArrayList.size();
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtName;
        public TextView txtSinger;
        public ImageView imgHinh;
        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.txtName);
            txtSinger=itemView.findViewById(R.id.txtSinger);
            imgHinh=itemView.findViewById(R.id.imgHinh);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position= getLayoutPosition();
            Music m=musicArrayList.get(position);
            Intent i= new Intent(context,PlayMusic.class);
            i.putExtra("txtName",m.getTxtName());
            i.putExtra("txtSinger",m.getTxtSinger());
            i.putExtra("imgHinh",m.getImgHinh());
            context.startActivity(i);
        }
    }
}
