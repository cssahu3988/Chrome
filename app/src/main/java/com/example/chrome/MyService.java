package com.example.chrome;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class MyService extends Service {
    public static final String CHANNEL_1="channel_Id_1";
    Notification notification=null;
    public MyService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        createNotificationChannels();
        Toast.makeText(this, "Service created", Toast.LENGTH_LONG).show();
        super.onCreate();
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel(
                    CHANNEL_1,"channel_1", NotificationManager.IMPORTANCE_LOW);
            channel.setDescription("channel 1");
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "On Start Command", Toast.LENGTH_SHORT).show();
        if (notification==null){
            notification=new Notification.Builder(this,App.CHANNEL_1)
                    .setContentTitle("MyNotification")
                    .build();
        }
        startForeground(1,notification);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}