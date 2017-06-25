package com.gjuan.mapas;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificarActivity extends AppCompatActivity {
    Button regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificar);

        savedInstanceState = getIntent().getExtras();
        String msg = savedInstanceState.getString("mensaje");

        regresar = (Button) findViewById(R.id.regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification n= new Notification.Builder(this)
                .setContentTitle("Nuevo Mensaje")
                .setContentText(msg)
                .setSmallIcon(R.drawable.notificacion)
                .setVibrate(new long[] {100, 250, 100, 500})
                .build();
        nm.notify(1,n);
    }
}
