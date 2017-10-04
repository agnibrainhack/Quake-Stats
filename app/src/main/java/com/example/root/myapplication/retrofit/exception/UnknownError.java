package com.example.root.myapplication.retrofit.exception;


import com.example.root.myapplication.R;
import com.example.root.myapplication.utils.ResourceUtils;

public class UnknownError extends BaseException {

    public UnknownError(){
        cause = ResourceUtils.instance().getString(R.string.alert_unknown_error);
        suggestion = ResourceUtils.instance().getString(R.string.alert_common_suggestion);
    }
}
