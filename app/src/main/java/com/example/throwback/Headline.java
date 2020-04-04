package com.example.throwback;

public class Headline {

    private int id;
    private String headline;
    private String url;
    private String date;

    public Headline(int id, String headline, String url, String date){
        this.id = id;
        this.headline = headline;
        this.url = url;
        this.date = date;
    }
    public Headline(String headline, String url, String date){
        this.headline = headline;
        this.url = url;
        this.date = date;
    }

    public String getHeadline() {
        return headline;
    }

    public String getUrl() {
        return url;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }
}
