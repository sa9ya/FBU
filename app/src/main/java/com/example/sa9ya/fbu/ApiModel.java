package com.example.sa9ya.fbu;

/**
 * Created by sa9ya on 26.09.2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiModel {

    @SerializedName("newsid")
    @Expose
    private int newsid;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("image")
    @Expose
    private String image;

    public int getId() { return newsid; }
    public void setId(int newsid) {
        this.newsid = newsid;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() { return description; }
    public void setDesc(String description) {
        this.description = description;
    }

    public String getImg() {
        return image;
    }
    public void setImg(String image) {
        this.image = image;
    }

}