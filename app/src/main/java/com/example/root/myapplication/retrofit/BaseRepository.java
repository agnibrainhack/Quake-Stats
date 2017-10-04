package com.example.root.myapplication.retrofit;


import com.example.root.myapplication.retrofit.exception.BaseException;

public abstract class BaseRepository {
    public interface Callback<T>{
        void onSuccess(T result);
        void onError(BaseException error);
    }
}
