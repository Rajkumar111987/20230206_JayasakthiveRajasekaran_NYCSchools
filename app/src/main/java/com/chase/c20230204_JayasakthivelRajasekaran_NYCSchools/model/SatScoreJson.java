package com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.model;

import com.google.gson.annotations.SerializedName;

public class SatScoreJson {

    @SerializedName("dbn")
    public String dbn;

    @SerializedName("school_name")
    public String schoolName;

    @SerializedName("num_of_sat_test_takers")
    public String numOfSatTestTakers;

    @SerializedName("sat_critical_reading_avg_score")
    public String satCriticalReadingAvgScore;

    @SerializedName("sat_math_avg_score")
    public String satMathAvgScore;

    @SerializedName("sat_writing_avg_score")
    public String satWritingAvgScore;
}
