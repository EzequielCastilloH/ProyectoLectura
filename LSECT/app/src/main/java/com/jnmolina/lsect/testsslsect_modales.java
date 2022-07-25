package com.jnmolina.lsect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class testsslsect_modales extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testsslsect_modales);
        WebView myWebView = (WebView) findViewById(R.id.webview_modales);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSeOZjQO2UuhZq-3xI_pMLjwZPjx5rzxzgamIdL6jIxe1wCBXw/viewform?usp=sf_link");
    }
}