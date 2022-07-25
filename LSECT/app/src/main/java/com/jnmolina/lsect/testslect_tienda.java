package com.jnmolina.lsect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class testslect_tienda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testslect_tienda);
        WebView myWebView = (WebView) findViewById(R.id.webview_tienda);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSdBEaVj5V5REq3Z9hfW4WaHYOet6yXO3GyYD9H0pit2LVvfQA/viewform?usp=sf_link");
    }
}