package com.jnmolina.lsect;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Random;

public class Fcm extends FirebaseMessagingService {
    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        Log.e("token","mi token es:"+token);
        saveToken(token);

    }

    private void saveToken(String token) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("token");
        ref.child("johanna").setValue(token);
    }

    @Override
    public void onMessageReceived(RemoteMessage message) {
        super.onMessageReceived(message);
        String from = message.getFrom();

        if (message.getData().size()>0){
            String title =message.getData().get("titulo");
            String detail =message.getData().get("detalle");

            mayorqueoreo(title, detail);
        }
    }
    private void mayorqueoreo(String title, String detail){
        String id="mensaje";
        NotificationManager nm=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,id);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel nc = new NotificationChannel(id, "nuevo", NotificationManager.IMPORTANCE_HIGH);
            nc.setShowBadge(true);
            assert nm != null;
            nm.createNotificationChannel(nc);
        }

        builder.setAutoCancel(true)
                .setWhen(System.currentTimeMillis())
                .setContentTitle("titulo")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("detalle")
                .setContentIntent(clickNotification())
                .setContentInfo("nuevo");
        Random random =new Random();
        int idNotify= random.nextInt(8000);

        assert nm != null;
        nm.notify(idNotify, builder.build());

    }

    public PendingIntent clickNotification(){
        Intent nf =new Intent(getApplicationContext(), MainActivity.class);
        nf.putExtra("color", "rojo");
        nf.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
        return PendingIntent.getActivity(this,0,nf,0);

    }
}
