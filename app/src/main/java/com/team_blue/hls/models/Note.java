package com.team_blue.hls.models;


import android.graphics.Bitmap;

import java.net.URL;

public class Note {
    private String id;
    private String image;
    private int likeCount;

    public Note()
    {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
