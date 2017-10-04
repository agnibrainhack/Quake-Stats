package com.example.root.myapplication.pojo;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BaseResponse implements Serializable {

    @SerializedName("responsecode")
    public String responseCode = "";

    @SerializedName("status")
    public String status = "";


    /**
     * Check whether this response object is valid i.e. contains any responseCode or not
     *
     * @return true if this response contains any responseCode otherwise false
     */
    public boolean containsValidResponse(){
        if(!TextUtils.isEmpty(this.responseCode)){
            return true;
        }

        return false;
    }

}
