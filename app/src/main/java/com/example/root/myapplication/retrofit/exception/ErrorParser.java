package com.example.root.myapplication.retrofit.exception;

import org.apache.http.conn.ConnectTimeoutException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

public class ErrorParser {
    public static BaseException parseError(Throwable t){
        if(t==null){
            return new UnknownError();
        }

        if (t instanceof SocketTimeoutException
                || t instanceof ConnectTimeoutException
                || t instanceof ConnectException
                || t instanceof UnknownHostException
                || t instanceof SSLPeerUnverifiedException
                || t instanceof SSLHandshakeException) {
            return new NetworkError(t);
        }else{
            return new UnknownError();
        }
    }
}
