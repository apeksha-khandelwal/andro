package com.example.apekshakhandelwal.news;

/**
 * Created by Apeksha Khandelwal on 25-05-2017.
 */

public class news
{
    private String title;
    private String type;
    private String date;
    private String sec;
    private String url;

    public news(String title, String type, String date, String section, String url)
    {
        this.title = title;
        this.type = type;
        this.date = date;
        this.sec = section;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getSection() {
        return sec;
    }

    public String getUrl() {
        return url;
    }
}
