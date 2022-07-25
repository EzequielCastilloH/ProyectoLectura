package com.jnmolina.lsect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class testslsect_saludos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testslsect);
        WebView myWebView = (WebView) findViewById(R.id.webview_saludos);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSeB7IsHrNF7xr0g86U_sbzcH_KnPsqXsNaq58oJNKn5--CDsw/viewform?usp=sf_link");
    }
}