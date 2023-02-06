package com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools;

import android.app.Application;

import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.rest.RestFactory;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.rest.RestInterface;

public class App extends Application {

    public static App app;
    public RestInterface rest;

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
        rest = createRest();
    }

    protected RestInterface createRest() {
        return RestFactory.build(RestInterface.class);
    }
}
