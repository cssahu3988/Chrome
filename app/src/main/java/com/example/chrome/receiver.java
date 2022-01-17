package com.example.chrome;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "receiver called", Toast.LENGTH_SHORT).show();
        Intent intent1=new Intent(context,MyService.class);
        context.startService(intent1);
    }
}
