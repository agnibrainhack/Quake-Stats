package com.example.root.myapplication.retrofit.exception;



import com.example.root.myapplication.R;
import com.example.root.myapplication.utils.ResourceUtils;

import org.apache.http.conn.ConnectTimeoutException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

public class NetworkError extends BaseException {
    /**
     * Default constructor for Network error which is to be used in case of No response from server.
     */
    public NetworkError(){
        cause = ResourceUtils.instance().getString(R.string.alert_network_no_response_from_server);
        suggestion = ResourceUtils.instance().getString(R.string.alert_common_suggestion);
    }

    /**
     * Constructor for Network error which receives only the cause of error
     * and provided a common suggestion.
     */
    public NetworkError(String cause){
        this.cause = cause;
        suggestion = ResourceUtils.instance().getString(R.string.alert_common_suggestion);
    }

    /**
     * Constructor for Network error which receives only the cause of error
     * and provided a common suggestion.
     */
    public NetworkError(String cause, String suggestion){
        this.cause = cause;
        this.suggestion = suggestion;
    }

    /**
     * Parse a {@link Throwable} thrown from network layer in this object with error messages
     * for some common type of Exceptions.
     *
     * <h1>Any unsupported type of Exception will throw {@link UnsupportedOperationException}</h1>
     *
     * Supported errors are:
     * <ul>
     *     <li>{@link SocketTimeoutException}</li>
     *     <li>{@link ConnectTimeoutException}</li>
     *     <li>{@link UnknownHostException}</li>
     *     <li>{@link SSLPeerUnverifiedException}</li>
     *     <li>{@link SSLHandshakeException}</li>
     * </ul>
     * @param throwable {@link UnsupportedOperationException} to be thrown
     *                                                       if any unsupported type is provided
     */
    public NetworkError(Throwable throwable){
        if (throwable instanceof SocketTimeoutException
                || throwable instanceof ConnectTimeoutException) {

            cause = ResourceUtils.instance().getString(R.string.alert_network_no_response_from_server);
            suggestion = ResourceUtils.instance().getString(R.string.alert_common_suggestion);
        }  else if (throwable instanceof UnknownHostException ||throwable instanceof ConnectException) {
            cause = ResourceUtils.instance().getString(R.string.alert_network_error);
            suggestion = ResourceUtils.instance().getString(R.string.alert_common_suggestion);
        } else if (throwable instanceof SSLPeerUnverifiedException
                || throwable instanceof SSLHandshakeException) {
            cause = ResourceUtils.instance().getString(R.string.alert_network_ssl_error);
            suggestion = ResourceUtils.instance().getString(R.string.alert_common_suggestion);
        }else{
            throw new UnsupportedOperationException();
        }
    }
}
