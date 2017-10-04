package com.example.root.myapplication.pojo.earthquakeModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;


public class Properties {
    @SerializedName("mag")
    @Expose
    public Float mag;
    @SerializedName("place")
    @Expose
    public String place;
    @SerializedName("time")
    @Expose
    public Long time;
    @SerializedName("updated")
    @Expose
    public Long updated;
    @SerializedName("tz")
    @Expose
    public Integer tz;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("detail")
    @Expose
    public String detail;
    @SerializedName("felt")
    @Expose
    public Object felt;
    @SerializedName("cdi")
    @Expose
    public Object cdi;
    @SerializedName("mmi")
    @Expose
    public Object mmi;
    @SerializedName("alert")
    @Expose
    public Object alert;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("tsunami")
    @Expose
    public Integer tsunami;
    @SerializedName("sig")
    @Expose
    public Integer sig;
    @SerializedName("net")
    @Expose
    public String net;
    @SerializedName("code")
    @Expose
    public String code;
    @SerializedName("ids")
    @Expose
    public String ids;
    @SerializedName("sources")
    @Expose
    public String sources;
    @SerializedName("types")
    @Expose
    public String types;
    @SerializedName("nst")
    @Expose
    public Integer nst;
    @SerializedName("dmin")
    @Expose
    public Float dmin;
    @SerializedName("rms")
    @Expose
    public Float rms;
    @SerializedName("gap")
    @Expose
    public String gap;
    @SerializedName("magType")
    @Expose
    public String magType;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("title")
    @Expose
    public String title;
}
