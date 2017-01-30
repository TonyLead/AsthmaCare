package com.asthmacare.asus.asthma.view.examview.examview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.asthmacare.asus.asthma.R;
import com.asthmacare.asus.asthma.adapters.LastResultsAdapter;
import com.asthmacare.asus.asthma.model.Results.Result;
import com.asthmacare.asus.asthma.presenter.ExamPresenter;
import com.asthmacare.asus.asthma.presenter.lastresultpresenter.LastResultPresenter;
import com.asthmacare.asus.asthma.view.examview.ActivityFragments;

import java.util.ArrayList;
import java.util.Date;


public class ExamFragment extends Fragment {
    private Button startExamButton;
   // private ExamFragment examFragment;

    private String date;
    private String exam;
    String id;
    EditText startExamEditText;
    TextView resultTextView;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exam, container, false);
        startExamButton = (Button) view.findViewById(R.id.start_exam_button);
        startExamEditText = (EditText) view.findViewById(R.id.start_exam_editText);
        resultTextView = (TextView)  view.findViewById(R.id.result_TextView);
        //examFragment = new ExamFragment();

        final ActivityFragments examActivity = (ActivityFragments) getActivity();
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            id = bundle.getString("id","id");
            Log.d("POIUY",id);
        }

        final Date mDate = new Date();
        date = mDate.toString();
        Log.d("wrqwe",date); //work
        Log.d("honi",id);
        startExamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exam = startExamEditText.getText().toString();
                Log.d("kopa",exam);
                ExamPresenter examPresenter = new ExamPresenter(ExamFragment.this,id,exam,date);

            }
        });
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_last);
        recyclerView.setHasFixedSize(true);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        LastResultPresenter lastResultPresenter = new LastResultPresenter(id,ExamFragment.this);


        return view;
    }
   public void setResultTextView(String percent){
       //Log.d("FixPrice",percent);
         resultTextView.setText("Вы в " + percent + " зоне");
    }

    public void showLastResult(ArrayList<Result> lastResults) {
        recyclerView.setAdapter(new LastResultsAdapter(this, lastResults));
    }

}


