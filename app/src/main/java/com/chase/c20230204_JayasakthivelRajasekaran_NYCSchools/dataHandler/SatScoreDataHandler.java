package com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.dataHandler;

import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.App;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.model.SatScoreJson;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.rest.RestInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Retrofit;

public class SatScoreDataHandler {

    private SatScoreListener mListener;

    public SatScoreDataHandler(SatScoreListener listener){
        mListener = listener;
    }

    public interface SatScoreListener{
        void onSuccessSatScore(List<SatScoreJson> response);
        void onError(String errorCode);
    }

    public void getSatScore(String id){

        RestInterface rest = App.app.rest;
        Call<List<SatScoreJson>> call = rest.getSatScore(id);
        call.enqueue(new Callback<List<SatScoreJson>>() {
            @Override
            public void onResponse(retrofit.Response<List<SatScoreJson>> response, Retrofit retrofit) {
                List<SatScoreJson> res;
                if(response.body() != null){
                    res = response.body();
                }else{
                    res= new ArrayList<>();
                }
                mListener.onSuccessSatScore(res);
            }

            @Override
            public void onFailure(Throwable t) {
                mListener.onError(t.getMessage());
            }
        });
    }
}
