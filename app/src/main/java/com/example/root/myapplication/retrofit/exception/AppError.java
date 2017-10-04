package com.example.root.myapplication.retrofit.exception;

public class AppError extends BaseException {
    public AppError() {
    }

    public AppError(String cause) {
        super(cause);
    }

    public AppError(String causeOfError, String suggestion) {
        super(causeOfError, suggestion);
    }
}
