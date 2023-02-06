package com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.manager.impls;

import androidx.annotation.NonNull;


import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.dataHandler.HighSchoolDataHandler;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.dataHandler.SatScoreDataHandler;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.manager.SchoolManager;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.model.HighSchoolsJson;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.model.SatScoreJson;

import java.util.List;

/*Its is to manage the calls
If  datas are cached locally once the call is made we can check for local cache
if cache is available we can retrieve from local cache instead of making the another call to backend*/
public class SchoolManagerImpl implements SchoolManager {
    @Override
    public void getHighSchool(@NonNull HighSchoolListener callback) {
        HighSchoolDataHandler highSchoolDataHandler = new HighSchoolDataHandler(new HighSchoolDataHandler.HighSchoolListener() {

            @Override
            public void onSuccessHighSchool(List<HighSchoolsJson> response) {
                callback.onReceiveHighSchool(response);
            }

            @Override
            public void onError(String errorCode) {
                callback.onError(errorCode);
            }
        });

        highSchoolDataHandler.getHighSchools();

    }

    @Override
    public void getSatScore(String id, @NonNull SatListener callback) {
        SatScoreDataHandler highSchoolDataHandler = new SatScoreDataHandler(new SatScoreDataHandler.SatScoreListener() {


            @Override
            public void onSuccessSatScore(List<SatScoreJson> response) {
                callback.onReceiveSatScore(response);
            }

            @Override
            public void onError(String errorCode) {
                callback.onError(errorCode);
            }
        });

        highSchoolDataHandler.getSatScore(id);
    }
}
