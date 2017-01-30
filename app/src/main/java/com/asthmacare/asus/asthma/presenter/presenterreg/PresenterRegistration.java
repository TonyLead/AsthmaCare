package com.asthmacare.asus.asthma.presenter.presenterreg;

import android.content.Intent;
import android.util.Log;

import com.asthmacare.asus.asthma.API;
import com.asthmacare.asus.asthma.model.registrationmodel.AddUserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Asus on 19.11.2016.
 */

public class PresenterRegistration {
    private String fname;
    private String name;
    private String sname;
    private String gender;
    private String growth;
    private String birthday;
    private String login;
    private String password;
    private Intent intent;


    public PresenterRegistration(String mfname, String mname, String msname, String mgender,
                                 String mgrowth, String mbirthday, String mlogin, String mpassword) {
        this.fname = mfname;
        this.password = mpassword;
        this.login = mlogin;
        this.birthday = mbirthday;
        this.growth = mgrowth;
        this.name = mname;
        this.sname = msname;
        this.gender = mgender;
        intent = new Intent();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://asthmacare.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(API.class).getAddUserResponse(fname,name,sname,
                gender,growth,birthday,login,password).enqueue(new Callback<AddUserResponse>() {
            @Override
            public void onResponse(Call<AddUserResponse> call, Response<AddUserResponse> response) {
                String pop = response.body().getMessage();


                if(pop == null){
                    Log.d("kek","null");
                }else {
                Log.d("kek",pop);
            }}

            @Override
            public void onFailure(Call<AddUserResponse> call, Throwable t) {

                Log.d("net", t.getMessage());
            }
        });
    }
}
