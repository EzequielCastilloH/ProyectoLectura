package com.jnmolina.lsect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

public class testslect_tienda extends AppCompatActivity {
    ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testslect_tienda);
        WebView myWebView = (WebView) findViewById(R.id.webview_tienda);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSdBEaVj5V5REq3Z9hfW4WaHYOet6yXO3GyYD9H0pit2LVvfQA/viewform?usp=sf_link");
        btnBack = (ImageButton) findViewById(R.id.btnBackTienda);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnBack = new Intent(testslect_tienda.this, MenuPrincipal.class);
                startActivity(btnBack);
            }
        });
    }
}