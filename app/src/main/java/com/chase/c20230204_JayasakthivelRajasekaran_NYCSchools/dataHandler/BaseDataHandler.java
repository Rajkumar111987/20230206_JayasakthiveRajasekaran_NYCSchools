package com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.dataHandler;

import androidx.annotation.NonNull;


import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.App;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.rest.RestInterface;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseDataHandler<T> implements Callback<T>{

    abstract void onSuccess(Response<T> response);
    abstract void onFailure(String message );

    protected RestInterface getRest() {
        return App.app.rest;
    }

    @Override
    public void onFailure(@NonNull Call<T> call, Throwable t) {

        onFailure(t.toString());
    }

    @Override
    public void onResponse(@NonNull Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            checkForSuccess(response);
        } else {
            onFailure(Integer.toString(response.code()));
        }
    }

    public void checkForSuccess(Response<T> response){
        if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
            onFailure("");
        }else{
            onSuccess(response);
        }
    }
}
