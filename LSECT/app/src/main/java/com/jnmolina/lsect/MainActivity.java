package com.jnmolina.lsect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button btnStart;
    Button specific;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart=(Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnStart =new Intent(MainActivity.this, MenuPrincipal.class);
                startActivity(btnStart);
            }

        });
       /* specific= findViewById(R.id.btnStart);
        specific.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callSpecific();
            }

        });*/
    }
    private void callSpecific() {
        RequestQueue myrequest = Volley.newRequestQueue(getApplicationContext());
        JSONObject json = new JSONObject();
        try {
            String token ="cKosAEv1RfKhjPJo9eEGuK:APA91bFRoZCRTcMosMV0nmmhcR0fXDgRLUnzXgibGlgvawng5gsDkx2WEFPyWw3UWx_GuvrC78fGHRNxnkm_9HDRyZDUfsJGAWGo_jPsi7OCTbqsBqQzDgxWcbRSdqfoUBebUq2xYgy8";
            json.put("to", token);
            JSONObject notification = new JSONObject();
            notification.put("titulo", "soy yo  el titulo");
            notification.put("detalle", "soy un detalle");

            json.put("data", notification);

            String URL ="https://fcm.googleapis.com/fcm/send";
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,URL,json, null, null){
                @Override
                public Map<String, String> getHeaders()  {
                    Map<String, String> header = new HashMap<>();
                    header.put("content-type", "application/json");
                    return header;


                }
            };

            myrequest.add(request);

        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}