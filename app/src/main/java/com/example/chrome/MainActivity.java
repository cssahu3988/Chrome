package com.example.chrome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BroadcastReceiver receiver= new receiver();
        try {
            this.unregisterReceiver(receiver);
        } catch (Exception e) {
            e.printStackTrace();
            if (!e.toString().equals("")){
                IntentFilter filter=new IntentFilter();
                filter.addAction(Intent.ACTION_POWER_CONNECTED);
                filter.addAction(Intent.ACTION_BOOT_COMPLETED);
                this.registerReceiver(receiver,filter);
            }
        }
    }

    public void start(View view) {
        Intent intent=new Intent(this,MyService.class);
        this.startService(intent);
    }

    public void stop(View view) {
        Intent intent=new Intent(this,MyService.class);
        this.stopService(intent);
    }


}