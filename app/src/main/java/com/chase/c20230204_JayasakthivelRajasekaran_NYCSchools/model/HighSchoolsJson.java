package com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.model;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HighSchoolsJson implements Serializable {

    @SerializedName("dbn")
    public String dbn;

    @SerializedName("school_name")
    public String schoolName;

    @SerializedName("boro")
    public String boro;

    @SerializedName("overview_paragraph")
    public String overviewParagraph;

    @SerializedName("school_10th_seats")
    public String school10thSeats;

    @SerializedName("academicopportunities1")
    public String academicOpportunities1;

    @SerializedName("academicopportunities2")
    public String academicOpportunities2;

    @SerializedName("academicopportunities3")
    public String academicOpportunities3;

    @SerializedName("ell_programs")
    public String ellPrograms;

    @SerializedName("addtl_info1")
    public String addtlInfo1;

    @SerializedName("diplomaendorsements")
    public String diplomaEndorsements;

    @SerializedName("language_classes")
    public String languageClasses;

    @SerializedName("advancedplacement_courses")
    public String advancedplacementCourses;

    @SerializedName("neighborhood")
    public String neighborhood;

    @SerializedName("building_code")
    public String buildingCode;

    @SerializedName("location")
    public String location;

    @SerializedName("phone_number")
    public String phoneNumber;

    @SerializedName("fax_number")
    public String faxNumber;

    @SerializedName("school_email")
    public String schoolEmail;

    @SerializedName("website")
    public String website;

    @SerializedName("subway")
    public String subway;

    @SerializedName("bus")
    public String bus;

    @SerializedName("grades2018")
    public String grades2018;

    @SerializedName("finalgrades")
    public String finalGrades;

    @SerializedName("total_students")
    public String totalStudents;

    @SerializedName("extracurricular_activities")
    public String extracurricularActivities;

    @SerializedName("school_sports")
    public String schoolSports;

    @SerializedName("attendance_rate")
    public String attendanceRate;

    @SerializedName("pct_stu_enough_variety")
    public String pctStuEnoughVariety;

    @SerializedName("pct_stu_safe")
    public String pctStuSafe;

    @SerializedName("school_accessibility_description")
    public String schoolAccessibilityDescription;

    @SerializedName("directions1")
    public String directions1;

    @SerializedName("requirement1_1")
    public String requirement1_1;

    @SerializedName("requirement2_1")
    public String requirement2_1;

    @SerializedName("requirement3_1")
    public String requirement3_1;

    @SerializedName("requirement4_1")
    public String requirement4_1;

    @SerializedName("requirement5_1")
    public String requirement5_1;

    @SerializedName("offer_rate1")
    public String offerRate1;

    @SerializedName("program1")
    public String program1;

    @SerializedName("eligibility1")
    public String eligibility;

    @SerializedName("code1")
    public String code1;

    @SerializedName("interest1")
    public String interest1;

    @SerializedName("method1")
    public String method1;

    @SerializedName("seats9ge1")
    public String seats9ge1;

    @SerializedName("grade9gefilledflag1")
    public String grade9gefilledflag1;

    @SerializedName("grade9geapplicants1")
    public String grade9geapplicants1;

    @SerializedName("seats9swd1")
    public String seats9swd1;

    @SerializedName("grade9swdfilledflag1")
    public String grade9swdfilledflag1;

    @SerializedName("grade9swdapplicants1")
    public String grade9swdapplicants1;

    @SerializedName("seats101")
    public String seats101;

    @SerializedName("admissionspriority11")
    public String admissionspriority11;

    @SerializedName("admissionspriority21")
    public String admissionspriority21;

    @SerializedName("admissionspriority31")
    public String admissionspriority31;

    @SerializedName("grade9geapplicantsperseat1")
    public String grade9geapplicantsperseat1;

    @SerializedName("grade9swdapplicantsperseat1")
    public String grade9swdapplicantsperseat1;

    @SerializedName("primary_address_line_1")
    public String primaryAddressLine_1;

    @SerializedName("city")
    public String city;

    @SerializedName("zip")
    public String zip;

    @SerializedName("state_code")
    public String stateCode;

    @SerializedName("latitude")
    public String latitude;

    @SerializedName("longitude")
    public String longitude;

    @SerializedName("community_board")
    public String communityBoard;

    @SerializedName("council_district")
    public String councilDistrict;

    @SerializedName("census_tract")
    public String censusTract;

    @SerializedName("bin")
    public String bin;

    @SerializedName("bbl")
    public String bbl;

    @SerializedName("nta")
    public String nta;

    @SerializedName("borough")
    public String borough;

    @SerializedName("num_of_sat_test_takers")
    public String numOfSatTestTakers;

    @SerializedName("sat_critical_reading_avg_score")
    public String satCriticalReadingAvgScore;

    @SerializedName("sat_math_avg_score")
    public String satMathAvgScore;

    @SerializedName("sat_writing_avg_score")
    public String satWritingAvgScore;

    public void setNumOfSatTestTakers(String numOfSatTestTakers) {
        this.numOfSatTestTakers = numOfSatTestTakers;
    }

    public void setSatCriticalReadingAvgScore(String satCriticalReadingAvgScore) {
        this.satCriticalReadingAvgScore = satCriticalReadingAvgScore;
    }

    public void setSatMathAvgScore(String satMathAvgScore) {
        this.satMathAvgScore = satMathAvgScore;
    }

    public void setSatWritingAvgScore(String satWritingAvgScore) {
        this.satWritingAvgScore = satWritingAvgScore;
    }

    public String getTotalStudents(){
        return "Total Students : " + totalStudents;
    }

    public String getAttendanceRate(){
        return "Attendance Rate : " + attendanceRate;
    }

    public String getSchoolSports(){
        return "Sports : " + (TextUtils.isEmpty(schoolSports) ? "Not Available" : schoolSports);
    }

    public String getExtracurricularActivities(){
        return "Extracurricular : " + (TextUtils.isEmpty(extracurricularActivities) ? "Not Available" : extracurricularActivities);
    }

    public String getCityName(){
        return "City : " + (TextUtils.isEmpty(city) ? "Not Available" : city);
    }

    public String getWebsite(){
        return (website.contains("http") ? website : "http://"+website);
    }

    public boolean hasRequirement1(){
        return !TextUtils.isEmpty(requirement1_1);
    }

    public List<String> getRequirements(){
        List<String> requirement = new ArrayList<>();
        if(!TextUtils.isEmpty(requirement1_1)){
            requirement.add(requirement1_1);
        }if(!TextUtils.isEmpty(requirement2_1)){
            requirement.add(requirement2_1);
        }if(!TextUtils.isEmpty(requirement3_1)){
            requirement.add(requirement3_1);
        }if(!TextUtils.isEmpty(requirement4_1)){
            requirement.add(requirement4_1);
        }if(!TextUtils.isEmpty(requirement5_1)){
            requirement.add(requirement5_1);
        }
        return requirement;
    }

    public List<String> getOppturnity(){
        List<String> oppturnity = new ArrayList<>();
        if(!TextUtils.isEmpty(academicOpportunities1)){
            oppturnity.add(academicOpportunities1);
        }if(!TextUtils.isEmpty(academicOpportunities2)){
            oppturnity.add(academicOpportunities2);
        }if(!TextUtils.isEmpty(academicOpportunities3)){
            oppturnity.add(academicOpportunities3);
        }
        return oppturnity;
    }

    public List<String> getEligibility(){
        List<String> values = new ArrayList<>();
        if(!TextUtils.isEmpty(eligibility)){
            values.add(eligibility);
        }
        return values;
    }

    public boolean hasRequirement2(){
        return !TextUtils.isEmpty(requirement2_1);
    }

    public boolean hasRequirement3(){
        return !TextUtils.isEmpty(requirement3_1);
    }

    public boolean hasRequirement4(){
        return !TextUtils.isEmpty(requirement4_1);
    }

    public boolean hasRequirement5(){
        return !TextUtils.isEmpty(requirement5_1);
    }

    public boolean hasEligibility(){
        return !TextUtils.isEmpty(eligibility);
    }

    public boolean hasDirection(){
        return !TextUtils.isEmpty(directions1);
    }

    public boolean hasAddInfo(){
        return !TextUtils.isEmpty(addtlInfo1);
    }

    public boolean hasOppturnity1(){
        return !TextUtils.isEmpty(academicOpportunities1);
    }

    public boolean hasOppturnity2(){
        return !TextUtils.isEmpty(academicOpportunities2);
    }

    public boolean hasOppturnity3(){
        return !TextUtils.isEmpty(academicOpportunities3);
    }

    public boolean hasPrograms(){
        return !TextUtils.isEmpty(ellPrograms);
    }

    public boolean haslanguage(){
        return !TextUtils.isEmpty(languageClasses);
    }

    public boolean hasAdvancementCourses(){
        return !TextUtils.isEmpty(advancedplacementCourses);
    }

    public boolean hasDiploma(){
        return !TextUtils.isEmpty(diplomaEndorsements);
    }

    public boolean hasInfo(){
        return !TextUtils.isEmpty(overviewParagraph);
    }

    public boolean hasWeb(){
        return !TextUtils.isEmpty(website);
    }

    public boolean hasPhone(){
        return !TextUtils.isEmpty(phoneNumber);
    }

    public boolean hasEmail(){
        return !TextUtils.isEmpty(schoolEmail);
    }

    public boolean hasDirections(){
        return !TextUtils.isEmpty(latitude) || !TextUtils.isEmpty(longitude);
    }

    public String getEligibilityValue(){
        return eligibility;
    }
}
