package com.asthmacare.asus.asthma.view.examview.remindersview;



import android.app.AlarmManager;
import android.app.DialogFragment;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.asthmacare.asus.asthma.R;
import com.asthmacare.asus.asthma.presenter.presenterreminders.PresenterReminders;

import java.util.Calendar;


public class RemindersFragment extends Fragment {
    private Button morningTimeButton;
    private Button eveningTimeButton;
    private Button saveButton;
    private int hour_x;
    private int minut_x;
    private static final int DIALOG_ID = 0;
    private TextView timeMorningTextView;
    private TextView timeEveningTextView;
    private Integer timeMorningHours;
    private Integer timeMorningMinutes;
    private Integer timeEveningHours;
    private Integer timeEveningMinutes;
    private AlarmManager mAlarmManager;
    private PendingIntent mContentIntent;
    private Context context;







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reminders, container, false);


        morningTimeButton = (Button) view.findViewById(R.id.button_morning_time);
        eveningTimeButton = (Button) view.findViewById(R.id.button_evening_time);
        saveButton = (Button) view.findViewById(R.id.save_button);
        final TextView timeEveningHoursTv = (TextView) view.findViewById(R.id.time_evening_hours_textview);
        final TextView timeEveningMinutesTv = (TextView) view.findViewById(R.id.time_evening_minutes_textview);
        final TextView timeMorningHoursTv = (TextView) view.findViewById(R.id.time_morning_hours_textview);
        final TextView timeMorningMinutesTv = (TextView) view.findViewById(R.id.time_morning_minutes_textview);




        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (timeMorningHoursTv.getText().toString() == null && timeMorningMinutesTv.getText().toString() == null) {

                } else {
                    timeMorningHours = Integer.valueOf(timeMorningHoursTv.getText().toString()); // work
                    // Log.d(timeEveningHours,"EveningTime");
                    timeMorningMinutes = Integer.valueOf(timeMorningMinutesTv.getText().toString());
                }
                if (timeEveningHoursTv.getText().toString() == null && timeEveningMinutesTv.getText().toString() == null) {

                } else {
                    timeEveningHours = Integer.valueOf((timeEveningHoursTv.getText().toString()));
                    timeEveningMinutes = Integer.valueOf((timeEveningMinutesTv.getText().toString()));
                }

                if (timeMorningHoursTv.getText().toString() == null & timeEveningHoursTv.getText().toString() != null) {
                    Toast.makeText(getActivity(),
                            "Вы не выбрали утреннее время", Toast.LENGTH_SHORT);
                } else if (timeMorningHoursTv.getText().toString() != null & timeEveningHoursTv.getText().toString() == null) {
                    Toast.makeText(getActivity(),
                            "Вы не выбрали вечернее время", Toast.LENGTH_SHORT);
                } else {
                    Toast.makeText(getActivity(),
                            "Вы не выбрали время", Toast.LENGTH_SHORT);
                }


                PresenterReminders presenterRemindersMorning = new PresenterReminders(RemindersFragment.this,getActivity(),timeMorningHours,timeMorningMinutes);
                PresenterReminders presenterRemindersEvening = new PresenterReminders(RemindersFragment.this,getActivity(),timeEveningHours,timeEveningMinutes);





              //  restartNotify(timeMorningHours,timeMorningMinutes);
              //  restartNotify(timeEveningHours,timeEveningMinutes);

               // NotificationService service = new NotificationService();
             //   getActivity().startService(new Intent(getActivity(),NotificationService.class));
/*
                alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
                Intent notifyIntent = new Intent(getActivity(), MyReceiver.class);
                contentIntent = PendingIntent.getBroadcast(getActivity(), 0,
                        notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT );

                Calendar calendar = Calendar.getInstance();
                Calendar cal = Calendar.getInstance();

                calendar.set(Calendar.YEAR, cal.get(Calendar.YEAR));
                calendar.set(Calendar.MONTH, cal.get(Calendar.MONTH));
                calendar.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 15);
                calendar.set(Calendar.MILLISECOND, 0);

                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), contentIntent);


*/
            }
        });



        morningTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.FragmentManager fm = getActivity().getFragmentManager(); // woooow
                DialogFragment newFragment = new TimePickermMorning();
                newFragment.show(fm,"Tag");

//

        eveningTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.app.FragmentManager fm = getActivity().getFragmentManager(); // woooow
                DialogFragment newFragment = new TimePickerEvening();
                newFragment.show(fm,"TAG");


               // Log.d(timeEveningHours,"MorningTime");




            }
        });







            }
        });

        return view;




    }


    //What is it? Shaman?
    public void restartNotify(int hours, int minutes,AlarmManager alarmManager ,PendingIntent contentIntent) {



        Calendar calendar = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();

        calendar.set(Calendar.YEAR, cal.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, cal.get(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, hours);
        calendar.set(Calendar.MINUTE, minutes);
        calendar.set(Calendar.SECOND, 15);
        calendar.set(Calendar.MILLISECOND, 0);

        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), contentIntent);

       /* Context context = getActivity();

        Log.d("Trash", String.valueOf(hours));
        Log.d("Trash", String.valueOf(minutes));

        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent notifyIntent = new Intent(context, MyReceiver.class);
        contentIntent = PendingIntent.getBroadcast(context, 0,
                notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT );

        Calendar calendar = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();

        calendar.set(Calendar.YEAR, cal.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, cal.get(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, hours);
        calendar.set(Calendar.MINUTE, minutes);
        calendar.set(Calendar.SECOND, 15);
        calendar.set(Calendar.MILLISECOND, 0);

        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), contentIntent);
        */
    }



}

