package com.example.gmailrecyclerview.Models;

import java.util.Random;

public class gmail_item {
    private String username;
    private String title;
    private String content;
    private boolean isFavorite;
    private int colorAvt;
    public gmail_item(String username, String title, String content) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.isFavorite = false;
        Random r=new Random();
        this.colorAvt=r.nextInt();
    }

    public int getColorAvt() {
        return colorAvt;
    }

    public void setColorAvt(int colorAvt) {
        this.colorAvt = colorAvt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
