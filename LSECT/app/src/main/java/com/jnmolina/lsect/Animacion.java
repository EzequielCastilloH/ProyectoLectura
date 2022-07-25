package com.jnmolina.lsect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class Animacion extends AppCompatActivity {

    String phrase, url;
    ImageButton btnBack, btnRepeatAnimation;
    Button btnNextAnimation;
    TextView txtPhrase, txtModule;
    Integer position;
    private ListView listPhrases;
    private List<String> listArrayPhrases = new ArrayList<>();

    VideoView video;

    String phraseClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animacion);

        txtPhrase =(TextView) findViewById(R.id.txtPhrase);
        txtModule = findViewById(R.id.txtModule);
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnRepeatAnimation = (ImageButton) findViewById(R.id.btnRepeatAnimation);
        btnNextAnimation = (Button) findViewById(R.id.btnNextAnimation);

        phrase = getIntent().getStringExtra("phrase");
        url = getIntent().getStringExtra("url");
        phraseClass = getIntent().getStringExtra("class");
        listArrayPhrases = (ArrayList<String>) getIntent().getSerializableExtra("ArrayPhrases");
        position = getIntent().getIntExtra("position",0);
        txtPhrase.setText(phrase);
        txtModule.setText(phraseClass);


        MediaController controller = new MediaController(this);

        video = findViewById(R.id.video);
        video.setMediaController(controller);
        controller.setAnchorView(video);

        Uri uri = Uri.parse(url);
        video.setVideoURI(uri);
        video.start();


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnBack;
                switch (phraseClass){
                    case "Saludos":
                        btnBack = new Intent(Animacion.this, Frases1.class);
                        startActivity(btnBack);
                        break;
                    case "Modales":
                        btnBack = new Intent(Animacion.this, Frases2.class);
                        startActivity(btnBack);
                        break;
                    case "Escuela":
                        btnBack = new Intent(Animacion.this, Frases3.class);
                        startActivity(btnBack);
                        break;
                    case "Tienda":
                        btnBack = new Intent(Animacion.this, Frases4.class);
                        startActivity(btnBack);
                        break;
                }


            }
        });

        /*btnNextAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent btnNextAnimation = new Intent(Animacion.this, Animacion.this);
                btnNextAnimation.putExtra("phrase",listArrayPhrases.get(position+1));
                startActivity(btnNextAnimation);
            }
        });
            */
        btnRepeatAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video.start();
            }
        });






    }
}