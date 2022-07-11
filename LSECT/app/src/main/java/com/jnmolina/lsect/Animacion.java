package com.jnmolina.lsect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

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