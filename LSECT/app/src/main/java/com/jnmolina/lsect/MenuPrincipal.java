package com.jnmolina.lsect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

public class MenuPrincipal extends AppCompatActivity {
    private GridView grid;
    Button btnSaludos, btnModales, btnEscuela, btnTienda;

    ArrayList<String> nameSituation = new ArrayList<>();
    ArrayList<Integer> imgSituation = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        /*grid =findViewById(R.id.categories);

        nameSituation.add("Llamada telefónica");
        nameSituation.add("Mercado");
        nameSituation.add("Saludos");
        nameSituation.add("Despedidas");
        nameSituation.add("Cortesía");

        imgSituation.add(R.drawable.imgPhoneCall);
        imgSituation.add(R.drawable.imgMarket);
        imgSituation.add(R.drawable.imgHello);
        imgSituation.add(R.drawable.imGoodbye);
        imgSituation.add(R.drawable.imgCortesy);

        GridAdapter adapter = new GridAdapter();
        grid.setAdapter(adapter);*/

        btnSaludos = (Button) findViewById(R.id.btnTry1);
        btnModales = findViewById(R.id.btnTry2);
        btnEscuela = findViewById(R.id.btnTry3);
        btnTienda = findViewById(R.id.btnTry4);

        btnSaludos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnNextPage = new Intent(MenuPrincipal.this, Frases1.class);
                startActivity(btnNextPage);
            }
        });

        btnModales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnNextPage = new Intent(MenuPrincipal.this, Frases2.class);
                startActivity(btnNextPage);
            }
        });

        btnEscuela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnNextPage = new Intent(MenuPrincipal.this, Frases3.class);
                startActivity(btnNextPage);
            }
        });

        btnTienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnNextPage = new Intent(MenuPrincipal.this, Frases4.class);
                startActivity(btnNextPage);
            }
        });

      



    }

}