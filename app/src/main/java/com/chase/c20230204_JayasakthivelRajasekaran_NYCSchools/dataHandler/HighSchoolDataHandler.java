package com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.dataHandler;


import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.App;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.model.HighSchoolsJson;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.rest.RestInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Retrofit;

public class HighSchoolDataHandler{
    private HighSchoolListener mListener;

    public HighSchoolDataHandler(HighSchoolListener listener){
        mListener = listener;
    }

    public interface HighSchoolListener{
        void onSuccessHighSchool(List<HighSchoolsJson> response);
        void onError(String errorCode);
    }

    public void getHighSchools(){

        RestInterface rest = App.app.rest;
        Call<List<HighSchoolsJson>> call = rest.getAllHighSchools();
        call.enqueue(new Callback<List<HighSchoolsJson>>() {
            @Override
            public void onResponse(retrofit.Response<List<HighSchoolsJson>> response, Retrofit retrofit) {
                List<HighSchoolsJson> res;
                if(response.body() != null){
                    res = response.body();
                }else{
                    res= new ArrayList<>();
                }
                mListener.onSuccessHighSchool(res);
            }

            @Override
            public void onFailure(Throwable t) {
                mListener.onError(t.getMessage());
            }
        });
    }
}
