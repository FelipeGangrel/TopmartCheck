package com.fococomunicacao.topmartcheck;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

/**
 * Created by Administrador on 22/01/2016.
 */
public class LocationReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent){
        Toast.makeText(context, "Capturando Localização", Toast.LENGTH_SHORT).show();
        Vibrator vibrator = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);
    }
}
