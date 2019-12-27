package tw.org.iii.android201923;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = new Timer();
    }

    Timer timer;

    NotificationManager notificationManager;
    public void test1(View view) {

        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.v("brad", "new ver.");
            CharSequence name = "Brad Channel";
            String description = "Greate Channel";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("My ID", name, importance);
            channel.setDescription(description);
            channel.setDescription(description);
            channel.setShowBadge(true);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }else{
            notificationManager = getSystemService(NotificationManager.class);
        }



        //sendNotify();

        timer.schedule(new MyTask(), 10*1000);

    }

    private class MyTask extends TimerTask {
        @Override
        public void run() {
            sendNotify();
        }
    }

    private void sendNotify(){
        Log.v("brad", "send");


        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("title")
                .setContentText("content")
                .build();
        notificationManager.notify(1,notification);
    }




}
