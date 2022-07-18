package com.jnmolina.lsect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.Objects;

public class Frases1 extends AppCompatActivity {

    private ListView listPhrases;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

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

        db.collection("frases1").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (QueryDocumentSnapshot document : task.getResult()){
                        String frase = document.getData().get("frase").toString();
                        Log.d("Dato",document.getId() + " => " + frase);

                        listArrayPhrases.add(new ObjectList(R.drawable.play, frase));

                    }
                } else {
                    Log.w("Error", "Error", task.getException());
                }
                //Adaptando el envío de datos

                listPhrases.setAdapter(new AdaptadorLista(Frases1.this, R.layout.listview,listArrayPhrases){
                    @Override
                    public void onEntrada(Object entrada, View view) {
                        TextView texto_superior_entrada = (TextView) view.findViewById(R.id.txtPhraseTitle);
                        ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imgPlay);

                        texto_superior_entrada.setText(((ObjectList) entrada).getPhraseTitle());
                        imagen_entrada.setImageResource(((ObjectList) entrada).getIdImage());
                    }
                });
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