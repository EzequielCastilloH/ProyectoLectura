package com.jnmolina.lsect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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

    String phrase;
    ImageButton btnBack, btnRepeatAnimation;
    Button btnNextAnimation;
    TextView txtPhrase;
    Integer position;
    private ListView listPhrases;
    private List<String> listArrayPhrases = new ArrayList<>();

    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animacion);

        txtPhrase =(TextView) findViewById(R.id.txtPhrase);
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnRepeatAnimation = (ImageButton) findViewById(R.id.btnRepeatAnimation);
        btnNextAnimation = (Button) findViewById(R.id.btnNextAnimation);

        phrase = getIntent().getStringExtra("phrase");
        listArrayPhrases = (ArrayList<String>) getIntent().getSerializableExtra("ArrayPhrases");
        position = getIntent().getIntExtra("position",0);
        txtPhrase.setText(phrase);

        MediaController controller = new MediaController(this);

        video = findViewById(R.id.video);
        video.setMediaController(controller);
        controller.setAnchorView(video);

        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/pinheads-f0e32.appspot.com/o/0001-0250.mp4?alt=media&token=0aa88a53-c03c-43e1-94f4-ee5668a0c80d");
        video.setVideoURI(uri);
        video.start();


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnBack = new Intent(Animacion.this, Frases1.class);
                startActivity(btnBack);
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

        btnRepeatAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

         */




    }
}