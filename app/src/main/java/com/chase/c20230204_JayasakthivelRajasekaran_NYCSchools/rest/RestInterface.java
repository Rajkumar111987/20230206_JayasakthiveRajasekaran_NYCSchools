package com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.rest;


import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.model.HighSchoolsJson;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.model.SatScoreJson;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface RestInterface {


    @GET("resource/s3k6-pzi2.json")
    Call<List<HighSchoolsJson>> getAllHighSchools();

    @GET("resource/f9bf-2cp4.json")
    Call<List<SatScoreJson>> getSatScore(@Query("dbn") String id);
}
