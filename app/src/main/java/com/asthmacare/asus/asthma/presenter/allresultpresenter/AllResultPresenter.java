package com.asthmacare.asus.asthma.presenter.allresultpresenter;

import android.widget.Toast;

import com.asthmacare.asus.asthma.API;
import com.asthmacare.asus.asthma.model.Results.AllResultResponse;
import com.asthmacare.asus.asthma.model.Results.Result;
import com.asthmacare.asus.asthma.view.examview.ResultsFragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tony on 10.01.2017.
 */

public class AllResultPresenter {
    private ResultsFragment resultsFragment;
    private ArrayList<Result> results;
    private String id;

    public AllResultPresenter(String mId, final ResultsFragment mResultsFragment) {
        this.id = mId;
        this.resultsFragment = mResultsFragment;
        results = new ArrayList<>();




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://asthmacare.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(API.class).getAllResultResponse(id).enqueue(new Callback<AllResultResponse>() {
            @Override
            public void onResponse(Call<AllResultResponse> call, Response<AllResultResponse> response) {
                //ArrayList<allRes>  = response.body().getResults();
                if(response.body().getResults() == null){
                    Toast.makeText(resultsFragment.getContext(),"Ошибка загрузки",Toast.LENGTH_LONG).show();
                }else{
                    results = response.body().getResults();

                    resultsFragment.showAllResult(results);
                }





               }

            @Override
            public void onFailure(Call<AllResultResponse> call, Throwable t) {

            }


        });
    }
    }

