package com.asthmacare.asus.asthma.view.examview.remindersview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    private static final String NOTIFICATION_TAG = "Message";

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        context.startService(new Intent(context,NotificationService.class));
       /* NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);



         intent = new Intent(context,ActivityFragments.class);
        intent.putExtra("ExamFragment","ExamFragment");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,0);

        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.drawable.icon);
        mBuilder.setContentTitle("Уведомление");
        mBuilder.setContentText("Вам нужно срочно проверить результаты");

        notify(context,mBuilder.build());

    }

    @TargetApi(Build.VERSION_CODES.ECLAIR)
    private static void notify(final Context context, final Notification notification) {
       NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR) {
            mNotificationManager.notify(NOTIFICATION_TAG, 0, notification);
        } else {
            mNotificationManager.notify(NOTIFICATION_TAG.hashCode(), notification);
        }
    }
}
*/

    }
}