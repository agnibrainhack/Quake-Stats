package com.example.root.myapplication.retrofit;


import android.content.Context;

import com.example.root.myapplication.pojo.BaseResponse;
import com.example.root.myapplication.pojo.earthquakeModel.Earthquake;
import com.example.root.myapplication.retrofit.exception.ErrorParser;
import com.example.root.myapplication.retrofit.exception.NetworkError;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitRepository extends BaseRepository {

    private RetrofitService apiService;

    public RetrofitRepository() {
        init();
    }

    /**
     * To initialize Retrofit Service class
     */
    private void init() {
        apiService = ServiceGenerator.createService(RetrofitService.class);
    }

    /**
     * Call api
     *
     * @param format
     * @param startTime
     * @param endTime
     * @param callback  Interface to get callback on api call completion
     */
    public void callAPI(String format, String startTime, String endTime,String minm, final Callback callback) {
        Call<Earthquake> call = apiService.getDetails(format, startTime, endTime,minm);
        call.enqueue(new retrofit2.Callback<Earthquake>() {

            @Override
            public void onResponse(Call<Earthquake> call, Response<Earthquake> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    // This may be the case where HTTP status codes is not set as 200-OK in server
                    // In that case, check if server has sent any JSON response even if the HTTP code is not success.
                    BaseResponse errorResponse = RetrofitErrorParser.getBaseErrorResponse(response);

                    if (errorResponse != null && errorResponse.containsValidResponse()) {
                        callback.onSuccess(errorResponse);
                    } else {
                        callback.onError(new NetworkError());
                    }
                }
            }

            @Override
            public void onFailure(Call<Earthquake> call, Throwable t) {
                callback.onError(ErrorParser.parseError(t));
            }
        });

    }
}
