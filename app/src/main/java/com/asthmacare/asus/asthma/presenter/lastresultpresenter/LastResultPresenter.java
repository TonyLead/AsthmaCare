package com.asthmacare.asus.asthma.presenter.lastresultpresenter;

import android.widget.Toast;

import com.asthmacare.asus.asthma.API;
import com.asthmacare.asus.asthma.model.Results.AllResultResponse;
import com.asthmacare.asus.asthma.model.Results.Result;
import com.asthmacare.asus.asthma.view.examview.examview.ExamFragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LastResultPresenter {

        private ExamFragment examFragment;
        private ArrayList<Result> lastResults;
        private String id;


        public LastResultPresenter(String mId, final ExamFragment mExamFragment) {
            this.id = mId;
            this.examFragment = mExamFragment;
            lastResults = new ArrayList<>();




            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://asthmacare.ru/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            retrofit.create(API.class).getLastResultResponse(id).enqueue(new Callback<AllResultResponse>() {
                @Override
                public void onResponse(Call<AllResultResponse> call, Response<AllResultResponse> response) {
                    //ArrayList<allRes>  = response.body().getResults();
                    if(response.body().getResults() == null){
                        Toast.makeText(examFragment.getContext(),"Ошибка загрузки",Toast.LENGTH_LONG).show();
                    }else{
                        lastResults = response.body().getResults();

                        examFragment.showLastResult(lastResults);
                    }





                }

                @Override
                public void onFailure(Call<AllResultResponse> call, Throwable t) {

                }


            });
        }
    }




