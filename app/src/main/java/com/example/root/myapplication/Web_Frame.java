package com.example.root.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by root on 2/10/17.
 */

public class Web_Frame extends AppCompatActivity {
    private WebView mWebView;
    private WebSettings webSettings;
    private ProgressDialog progrDialog=null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_web);
        Intent i=getIntent();
        String url=i.getStringExtra("webto");
        mWebView=(WebView)findViewById(R.id.web);
        mWebView.loadUrl(url);


        mWebView.setWebViewClient(new WebViewClient() {

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
            public void onLoadResource (WebView view, String url) {
                if (progrDialog == null) {
                    progrDialog = new ProgressDialog(Web_Frame.this);
                    progrDialog.setMessage("Loading...");
                    progrDialog.show();
                }
            }
            public void onPageFinished(WebView view, String url) {
                try{
                    if (progrDialog.isShowing()) {
                        progrDialog.dismiss();
                        progrDialog = null;
                    }
                    progrDialog.dismiss();
                }catch(Exception exception){
                    exception.printStackTrace();
                }
            }
        });



    }
}













