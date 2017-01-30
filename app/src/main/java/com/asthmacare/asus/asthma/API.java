package com.asthmacare.asus.asthma;

import com.asthmacare.asus.asthma.model.ExamModelResponse;
import com.asthmacare.asus.asthma.model.Results.AllResultResponse;
import com.asthmacare.asus.asthma.model.registrationmodel.AddUserResponse;
import com.asthmacare.asus.asthma.model.loginingmodel.LoginUserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Asus on 19.11.2016.
 */

public interface API {
    @GET("patient_reg.php")
    Call<AddUserResponse> getAddUserResponse(@Query("fname") String fname, @Query("name") String name, @Query("sname") String sname,
                                     @Query("sex") String gender, @Query("growth") String growth, @Query("b_date") String birthday,
                                     @Query("login") String login,@Query("pass") String password);

    @GET("patient_log.php")
    Call<LoginUserResponse> getLoginUserResponse(@Query("login") String login,
                                                 @Query("pass") String password);

    @GET("patient_exam.php")
    Call<ExamModelResponse> getExamModelResponse(@Query("id") String id,@Query("exam") String exam,
                                                 @Query("time") String date);

    @GET("patient_result.php")
    Call<AllResultResponse> getAllResultResponse(@Query("id") String id);

    @GET("patient_result2.php")
    Call<AllResultResponse> getLastResultResponse(@Query("id") String id);
}
