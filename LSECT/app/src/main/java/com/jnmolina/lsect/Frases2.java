package com.jnmolina.lsect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Frases2 extends AppCompatActivity {

    private ListView listPhrases;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    ArrayList<ObjectList> listArrayPhrases = new ArrayList<>();
    //private List<String> listArrayPhrases = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frases2);
        listPhrases = findViewById(R.id.listPhrases);
        btnBack = (ImageButton) findViewById(R.id.btnBackPhrases);

        db.collection("frases2").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String frase = document.getData().get("frase").toString();
                        String url = document.getData().get("url").toString();
                        Log.d("Dato", document.getId() + " => " + frase + " " + url);

                        listArrayPhrases.add(new ObjectList(R.drawable.play, frase, url, "Modales"));

                    }
                } else {
                    Log.w("Error", "Error", task.getException());
                }


                //Adaptando el envío de datos

                listPhrases.setAdapter(new AdaptadorLista(Frases2.this, R.layout.listview, listArrayPhrases) {
                    @Override
                    public void onEntrada(Object entrada, View view) {
                        TextView texto_superior_entrada = (TextView) view.findViewById(R.id.txtPhraseTitle);
                        ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imgPlay);
                        String videoUrl = null;
                        String claseInt;

                        texto_superior_entrada.setText(((ObjectList) entrada).getPhraseTitle());
                        imagen_entrada.setImageResource(((ObjectList) entrada).getIdImage());
                        videoUrl = ((ObjectList) entrada).getUrl();
                        claseInt = ((ObjectList) entrada).getPhraseClass();
                    }
                });
            }
        });

        listPhrases.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i < listArrayPhrases.size(); i++) {
                    if (position == listArrayPhrases.size() - 1) {

                        Intent myIntent = new Intent(Frases2.this, testslsect_saludos.class);
                        startActivity(myIntent);
                    } else if (position == i) {
                        Intent myIntent = new Intent(Frases2.this, Animacion.class);
                        myIntent.putExtra("phrase", listArrayPhrases.get(position).getPhraseTitle());
                        // myIntent.putExtra("phrase",listArrayPhrases.get(position));
                        // myIntent.putExtra("ArrayPhrases", (Serializable) listArrayPhrases);
                        myIntent.putExtra("position", position);
                        myIntent.putExtra("url", listArrayPhrases.get(position).getUrl());
                        myIntent.putExtra("class", listArrayPhrases.get(position).getPhraseClass());
                        startActivity(myIntent);
                    }

                }

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnBack = new Intent(Frases2.this, MenuPrincipal.class);
                startActivity(btnBack);
            }
        });


    }
}