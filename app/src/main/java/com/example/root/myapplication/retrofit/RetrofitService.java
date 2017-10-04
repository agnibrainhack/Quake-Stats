package com.example.root.myapplication.retrofit;


import com.example.root.myapplication.pojo.earthquakeModel.Earthquake;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

//import static android.R.attr.min;

public interface RetrofitService {

    @GET("1/query")
//    @FormUrlEncoded
    Call<Earthquake> getDetails(@Query("format") String format,
                                @Query("starttime") String starttime,
                                @Query("endtime") String endtime,
                                @Query("minmagnitude") String minm);


}