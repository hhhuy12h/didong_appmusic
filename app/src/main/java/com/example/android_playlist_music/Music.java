package com.example.android_playlist_music;

public class Music {
    private int imgHinh;
    private String txtName;
    private String txtSinger;

    public int getImgHinh() {
        return imgHinh;
    }

    public void setImgHinh(int imgHinh) {
        this.imgHinh = imgHinh;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getTxtSinger() {
        return txtSinger;
    }

    public void setTxtSinger(String txtSinger) {
        this.txtSinger = txtSinger;
    }

    public Music(int imgHinh, String txtName, String txtSinger) {
        this.imgHinh = imgHinh;
        this.txtName = txtName;
        this.txtSinger = txtSinger;
    }

    public Music() {
    }
}
