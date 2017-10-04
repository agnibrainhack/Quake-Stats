package com.example.root.myapplication.retrofit.exception;

public abstract class BaseException extends Throwable {
    protected String cause = "";
    protected String suggestion = "";

    public BaseException(){

    }

    public BaseException(String cause) {
        this.cause = cause;
    }

    public BaseException(String causeOfError, String suggestion) {
        this.cause = causeOfError;
        this.suggestion = suggestion;
    }


    public String getCauseOfError() {
        return cause;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public String getCauseAndSuggestionMessage() {
        return cause+" "+suggestion;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AppException{");
        sb.append("cause='").append(cause).append('\'');
        sb.append(", suggestion='").append(suggestion).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
