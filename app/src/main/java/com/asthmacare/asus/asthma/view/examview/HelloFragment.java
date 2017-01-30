package com.asthmacare.asus.asthma.view.examview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asthmacare.asus.asthma.R;


public class HelloFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hello, container, false);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String fname = bundle.getString("fname","fname2");
            Log.d("fnameHelloFragment",fname);
        }



        return view;
    }
}
