package com.asthmacare.asus.asthma.presenter;

import android.util.Log;
import android.widget.Toast;

import com.asthmacare.asus.asthma.API;
import com.asthmacare.asus.asthma.model.ExamModelResponse;
import com.asthmacare.asus.asthma.view.examview.examview.ExamFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class ExamPresenter {
    ExamFragment examFragment;
    String id;
    String exam;
    String date;

    public ExamPresenter(ExamFragment mexamFragment, String mid, String mexam,String mdate) {
        this.examFragment = mexamFragment;
        this.id = mid;
        this.exam = mexam;
        this.date = mdate;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://asthmacare.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(API.class).getExamModelResponse(id, exam, date).enqueue(new Callback<ExamModelResponse>() {
            @Override
            public void onResponse(Call<ExamModelResponse> call, Response<ExamModelResponse> response) {
                Log.d("Response",response.body().getPercent());
                if(response.body().getCode().equals("200")){
               String percent = response.body().getCathegory().toString();

                    if(percent.equals("red")){
                        percent = "красной";
                    }else if(percent.equals("green")){
                        percent = "зеленой";
                    } else if(percent.equals("yellow")){
                        percent = "желтой";
                    }
               examFragment.setResultTextView(percent);
            }else {
                    Toast.makeText(examFragment.getContext(),"Ошибка загрузки",Toast.LENGTH_LONG).show();
                }
                }

            @Override
            public void onFailure(Call<ExamModelResponse> call, Throwable t) {
                Log.d("Response",t.toString());
            }
        });

    }





}
