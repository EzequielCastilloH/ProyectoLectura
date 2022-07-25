package com.jnmolina.lsect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

public class testsslsect_modales extends AppCompatActivity {
    ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testsslsect_modales);
        WebView myWebView = (WebView) findViewById(R.id.webview_modales);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSeOZjQO2UuhZq-3xI_pMLjwZPjx5rzxzgamIdL6jIxe1wCBXw/viewform?usp=sf_link");

        btnBack = (ImageButton) findViewById(R.id.btnBackModales);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnBack = new Intent(testsslsect_modales.this, MenuPrincipal.class);
                startActivity(btnBack);
            }
        });
    }

}