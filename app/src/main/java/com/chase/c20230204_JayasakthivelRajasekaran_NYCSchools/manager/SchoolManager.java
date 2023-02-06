package com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.manager;

import androidx.annotation.NonNull;


import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.model.HighSchoolsJson;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.model.SatScoreJson;

import java.util.List;

public interface SchoolManager {

    /**
     * Callback for HighSchool.
     */
    interface HighSchoolListener {
        void onReceiveHighSchool(List<HighSchoolsJson> response);

        void onError(String message);
    }

    /**
     * Get the HighSchool  Response.
     *
     * @param callback response callback
     */
    void getHighSchool(@NonNull HighSchoolListener callback);

    /**
     * Callback for HighSchool.
     */
    interface SatListener {
        void onReceiveSatScore(List<SatScoreJson> response);

        void onError(String message);
    }

    /**
     * Get the HighSchool  Response.
     *
     * @param callback response callback
     */
    void getSatScore(String id ,@NonNull SatListener callback);
}
