package com.asthmacare.asus.asthma.presenter.presenterreminders;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.asthmacare.asus.asthma.view.examview.remindersview.MyReceiver;
import com.asthmacare.asus.asthma.view.examview.remindersview.RemindersFragment;

/**
 * Created by Tony on 09.01.2017.
 */

public class PresenterReminders {
    private RemindersFragment remindersFragment;
    private Context context;
    private AlarmManager alarmManager;
    private PendingIntent contentIntent;
    int hours;
    int minutes;

    public PresenterReminders(RemindersFragment remindersFragment, Context context,int hours,int minutes) {
        this.remindersFragment = remindersFragment;
        this.context = context;
        this.hours = hours;
        this.minutes = minutes;

        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent notifyIntent = new Intent(context, MyReceiver.class);
        contentIntent = PendingIntent.getBroadcast(context, 0,
                notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT );

        remindersFragment.restartNotify(hours,minutes,alarmManager,contentIntent);



    }
}
