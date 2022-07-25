package com.jnmolina.lsect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

public class testslect_escuela extends AppCompatActivity {
    ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testslect_escuela);
        WebView myWebView = (WebView) findViewById(R.id.webview_escuela);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSd76-9QBm5tAU274nhEpqY3xhuHuKUQnyomdWy3a4BB6b80kA/viewform?usp=sf_link");
        btnBack = (ImageButton) findViewById(R.id.btnBackEscuela);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnBack = new Intent(testslect_escuela.this, MenuPrincipal.class);
                startActivity(btnBack);
            }
        });
    }
}