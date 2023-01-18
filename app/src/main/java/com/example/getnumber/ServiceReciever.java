package com.example.getnumber;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import java.util.Locale;

public class ServiceReciever extends BroadcastReceiver {

    private BroadcastListener listener;
    public ServiceReciever(){

    }
    public ServiceReciever(BroadcastListener listener){
        this.listener = listener;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            System.out.println("Receiver start");
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            listener.doSomething(incomingNumber);
            Log.d("deb", incomingNumber);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
