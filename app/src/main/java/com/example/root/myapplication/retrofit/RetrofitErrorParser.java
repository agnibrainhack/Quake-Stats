package com.example.root.myapplication.retrofit;



import com.example.root.myapplication.pojo.BaseResponse;
import com.example.root.myapplication.retrofit.exception.BaseException;
import com.example.root.myapplication.retrofit.exception.NetworkError;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class RetrofitErrorParser {
    /**
     * Parse error received from server
     * @param response Error of type Response
     * @return Error of type BaseException
     */
    public static BaseException parseError(Response<?> response) {
        Converter<ResponseBody, BaseResponse> converter =
                ServiceGenerator.retrofit()
                        .responseBodyConverter(BaseResponse.class, new Annotation[0]);

        BaseResponse error;

        try {
            error = converter.convert(response.errorBody());

            if (error != null) {

                return new NetworkError(error.status, "");
            } else {
                return new NetworkError();
            }
        } catch (IOException e) {
            return new NetworkError();
        }

    }

    /**
     * Get error response from server
     * @param response The error response from server
     * @return Error of type BaseResponse
     */
    public static BaseResponse getBaseErrorResponse(Response<?> response) {
        Converter<ResponseBody, BaseResponse> converter =
                ServiceGenerator.retrofit()
                        .responseBodyConverter(BaseResponse.class, new Annotation[0]);

        BaseResponse error = null;

        try {
            error = converter.convert(response.errorBody());

        } catch (IOException e) {
        }
        return error;

    }
}
