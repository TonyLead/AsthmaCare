package com.asthmacare.asus.asthma.view.examview.remindersview;


import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.asthmacare.asus.asthma.R;

import java.util.Calendar;



//This is Fragment

public class TimePickermMorning extends DialogFragment implements TimePickerDialog.OnTimeSetListener{


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //Use the current time as the default values for the time picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        //Create and return a new instance of TimePickerDialog
        return new TimePickerDialog(getActivity(),this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }



    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView timeMorningHoursTv = (TextView) getActivity().findViewById(R.id.time_morning_hours_textview);
        TextView timeMorningMinutesTv = (TextView) getActivity().findViewById(R.id.time_morning_minutes_textview);
        Button timeMorningHoursBtn = (Button) getActivity().findViewById(R.id.button_morning_time);



        timeMorningHoursTv.setText(String.valueOf(hourOfDay));
        timeMorningMinutesTv.setText(String.valueOf(minute));
        timeMorningHoursBtn.setText(String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
    }
}
