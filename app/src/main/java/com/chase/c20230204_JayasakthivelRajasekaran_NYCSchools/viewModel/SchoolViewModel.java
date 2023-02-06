package com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.manager.SchoolManager;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.manager.impls.SchoolManagerImpl;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.model.HighSchoolsJson;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.model.SatScoreJson;

import java.util.ArrayList;
import java.util.List;

public class SchoolViewModel extends AndroidViewModel {

    private MutableLiveData<List<HighSchoolsJson>> mHighSchool;

    private MutableLiveData<List<SatScoreJson>> mSatScore;

    public SchoolViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<HighSchoolsJson>> getAllHighSchool(){
        mHighSchool = new MutableLiveData<>();

        SchoolManager manager = new SchoolManagerImpl();
        manager.getHighSchool(new SchoolManager.HighSchoolListener() {

            @Override
            public void onReceiveHighSchool(List<HighSchoolsJson> response) {
                mHighSchool.postValue(response);
            }

            @Override
            public void onError(String message) {
                List<HighSchoolsJson> highSchoolsJsons = new ArrayList<>();
                mHighSchool.postValue(highSchoolsJsons);
            }
        });

        return mHighSchool;
    }

    public LiveData<List<SatScoreJson>> getSatScore(String id){
        mSatScore = new MutableLiveData<>();

        SchoolManager manager = new SchoolManagerImpl();
        manager.getSatScore(id , new SchoolManager.SatListener() {


            @Override
            public void onReceiveSatScore(List<SatScoreJson> response) {
                mSatScore.postValue(response);
            }

            @Override
            public void onError(String message) {
                List<SatScoreJson> satScoreJsons = new ArrayList<>();
                mSatScore.postValue(satScoreJsons);
            }
        });

        return mSatScore;
    }


}
