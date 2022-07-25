package com.jnmolina.lsect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class testslect_escuela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testslect_escuela);
        WebView myWebView = (WebView) findViewById(R.id.webview_escuela);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSd76-9QBm5tAU274nhEpqY3xhuHuKUQnyomdWy3a4BB6b80kA/viewform?usp=sf_link");
    }
}