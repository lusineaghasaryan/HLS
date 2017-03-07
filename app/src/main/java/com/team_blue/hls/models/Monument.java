package com.team_blue.hls.models;


import android.graphics.Bitmap;

import java.net.URL;

public class Monument {
    private int id;
    private String name;
    private String desc;
    private URL image;
    private Note[] notes;
    private String urlMon;
    private int x;
    private int y;

    public Monument() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public URL getImage() {
        return image;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    public Note[] getNotes() {
        return notes;
    }

    public void setNotes(Note[] notes) {
        this.notes = notes;
    }

    public String getUrlMon() {
        return urlMon;
    }

    public void setUrlMon(String urlMon) {
        this.urlMon = urlMon;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
