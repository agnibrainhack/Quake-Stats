package com.example.root.myapplication.pojo.earthquakeModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Earthquake implements Parcelable {
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("metadata")
    @Expose
    public Metadata metadata;
    @SerializedName("features")
    @Expose
    public ArrayList<Feature> features = new ArrayList<>();
    @SerializedName("bbox")
    @Expose
    public List<Float> bbox = null;

    protected Earthquake(Parcel in) {
        type = in.readString();
    }

    public static final Creator<Earthquake> CREATOR = new Creator<Earthquake>() {
        @Override
        public Earthquake createFromParcel(Parcel in) {
            return new Earthquake(in);
        }

        @Override
        public Earthquake[] newArray(int size) {
            return new Earthquake[size];
        }
    };

    public ArrayList<Feature> ret_feat(){
        return features;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(type);
    }
}
