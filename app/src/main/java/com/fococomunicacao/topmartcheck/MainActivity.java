package com.fococomunicacao.topmartcheck;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private PendingIntent pendingIntent;
    private AlarmManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent alarmIntent = new Intent(this, LocationReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);
    }


    public void startLocationReceiver(View view){
        manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        int interval = 10 * 1000;

        manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent );

        Toast.makeText(this, "Serviço iniciado", Toast.LENGTH_SHORT).show();
    }

    public void stopLocationReceiver(View view){
        if(manager != null){
            Toast.makeText(this, "Serviço parado", Toast.LENGTH_SHORT).show();
            manager.cancel(pendingIntent);
        }
    }
}
