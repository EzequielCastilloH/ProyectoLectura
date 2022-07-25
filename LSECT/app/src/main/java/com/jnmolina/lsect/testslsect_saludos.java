package com.jnmolina.lsect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

public class testslsect_saludos extends AppCompatActivity {
    ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testslsect);
        WebView myWebView = (WebView) findViewById(R.id.webview_saludos);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSeB7IsHrNF7xr0g86U_sbzcH_KnPsqXsNaq58oJNKn5--CDsw/viewform?usp=sf_link");
        btnBack = (ImageButton) findViewById(R.id.btnBackSaludos);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnBack = new Intent(testslsect_saludos.this, MenuPrincipal.class);
                startActivity(btnBack);
            }
        });

    }

}