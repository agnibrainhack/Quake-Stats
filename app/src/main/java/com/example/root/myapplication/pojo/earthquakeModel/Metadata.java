package com.example.root.myapplication.pojo.earthquakeModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Metadata {

    @SerializedName("generated")
    @Expose
    public Long generated;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("api")
    @Expose
    public String api;
    @SerializedName("count")
    @Expose
    public Integer count;
}
