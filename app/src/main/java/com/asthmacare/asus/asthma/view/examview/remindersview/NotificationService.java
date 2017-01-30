package com.asthmacare.asus.asthma.view.examview.remindersview;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import com.asthmacare.asus.asthma.R;
import com.asthmacare.asus.asthma.view.examview.ActivityFragments;

public class NotificationService extends Service {
    private NotificationManager mNotificationManager;


    public NotificationService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sendNotification();

    }

    public void sendNotification() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.androidauthority.com/"));
     //   Context context = getApplicationContext();

        Intent intent = new Intent(this,ActivityFragments.class);
        intent.putExtra("ExamFragment","ExamFragment");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);

                mBuilder.setContentIntent(pendingIntent);
                mBuilder.setSmallIcon(R.drawable.icon);
                mBuilder.setContentTitle("Уведомление");
                mBuilder.setContentText("Вам нужно срочно проверить результаты");

        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        mNotificationManager.notify(001, mBuilder.build());

    }




    @Override
    public IBinder onBind(Intent intent) {
        return null;


    }
}
