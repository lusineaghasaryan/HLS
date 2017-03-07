package com.team_blue.hls.models;


import android.graphics.Bitmap;

import java.net.URL;

public class Note {
    private int id;
    private URL image;
    private int likeCount;

    public Note()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public URL getImage() {
        return image;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
