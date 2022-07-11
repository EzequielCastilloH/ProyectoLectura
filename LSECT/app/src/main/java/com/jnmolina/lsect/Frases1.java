package com.jnmolina.lsect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Frases1 extends AppCompatActivity {

    private ListView listPhrases;
    ArrayList<ObjectList> listArrayPhrases = new ArrayList<>();
    //private List<String> listArrayPhrases = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frases1);
        listPhrases = findViewById(R.id.listPhrases);
        btnBack = (ImageButton) findViewById(R.id.btnBackPhrases);

        //Enviando títulos de las frases como ObjectList hacia el ArrayList
        listArrayPhrases.add(new ObjectList(R.drawable.play, "¡Buenos días!"));
        listArrayPhrases.add(new ObjectList(R.drawable.play, "¡Buenas tardes!"));
        listArrayPhrases.add(new ObjectList(R.drawable.play, "¡Buenas noches!"));
        listArrayPhrases.add(new ObjectList(R.drawable.play, "BUHO"));
        listArrayPhrases.add(new ObjectList(R.drawable.play, "BUHO"));
        listArrayPhrases.add(new ObjectList(R.drawable.play, "BUHO"));
        listArrayPhrases.add(new ObjectList(R.drawable.play, "BUHO"));
        listArrayPhrases.add(new ObjectList(R.drawable.play, "BUHO"));
        listArrayPhrases.add(new ObjectList(R.drawable.play, "BUHO"));
        listArrayPhrases.add(new ObjectList(R.drawable.play, "BUHO"));
        listArrayPhrases.add(new ObjectList(R.drawable.play, "BUHO"));
        listArrayPhrases.add(new ObjectList(R.drawable.play, "BUHO"));
        listArrayPhrases.add(new ObjectList(R.drawable.play, "BUHO"));
        listArrayPhrases.add(new ObjectList(R.drawable.play, "BUHO"));
        listArrayPhrases.add(new ObjectList(R.drawable.play, "BUHO"));
        listArrayPhrases.add(new ObjectList(R.drawable.play, "BUHO"));


        //Adaptando el envío de datos

        listPhrases.setAdapter(new AdaptadorLista(this, R.layout.listview,listArrayPhrases){
            @Override
            public void onEntrada(Object entrada, View view) {
                TextView texto_superior_entrada = (TextView) view.findViewById(R.id.txtPhraseTitle);
                ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imgPlay);

                texto_superior_entrada.setText(((ObjectList) entrada).getPhraseTitle());
                imagen_entrada.setImageResource(((ObjectList) entrada).getIdImage());
            }
        });


        listPhrases.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i < listArrayPhrases.size(); i++) {
                    if (position == i) {
                        Intent myIntent = new Intent(Frases1.this, Animacion.class);
                        myIntent.putExtra("phrase",listArrayPhrases.get(position).getPhraseTitle());
                       // myIntent.putExtra("phrase",listArrayPhrases.get(position));
                       // myIntent.putExtra("ArrayPhrases", (Serializable) listArrayPhrases);
                        myIntent.putExtra("position",position);

                        startActivity(myIntent);
                    }
                }

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnBack = new Intent(Frases1.this, MenuPrincipal.class);
                startActivity(btnBack);
            }
        });


    }


}