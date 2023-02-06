package com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.rest;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class RestFactory {

    public static <T> T build(Class<T> interfaceClass) {
        OkHttpClient client = new OkHttpClient();

        // Original timing values
        client.setConnectTimeout(15, TimeUnit.SECONDS); // connect timeout
        client.setReadTimeout(30, TimeUnit.SECONDS);    // socket timeout


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://data.cityofnewyork.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(interfaceClass);
    }
}
