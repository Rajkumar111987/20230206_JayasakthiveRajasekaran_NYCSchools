package com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.view.dashboard.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.R;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.databinding.FragmentDashboardDetailCustomBinding;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.model.HighSchoolsJson;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.model.SatScoreJson;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.utils.SchoolUtils;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.view.dashboard.activity.DashboardActivity;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.viewModel.SchoolViewModel;

import java.util.Collections;
import java.util.List;

public class DashboardDetailCustomFragment extends Fragment {

    public static final String TAG = DashboardDetailCustomFragment.class.getSimpleName();

    private FragmentDashboardDetailCustomBinding mBinding;
    private DashboardActivity mActivity;
    int position = 0;
    HighSchoolsJson school;
    public SchoolViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = FragmentDashboardDetailCustomBinding.inflate(inflater,container,false);
        View view = mBinding.getRoot();
        mActivity = (DashboardActivity)requireActivity();
        if(getArguments() != null){
            position = getArguments().getInt(mActivity.SCHOOL_ID);
            school = mActivity.mSchools.get(position);
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getData();
    }

    private void getData() {
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(mActivity.getApplication()).create(SchoolViewModel.class);
        mBinding.progressbar.show();
        final Observer<List<SatScoreJson>> schoolObserver = schoolResponse ->{
            mBinding.progressbar.hide();
            if(schoolResponse.size() > 0){
                mBinding.llView.setVisibility(View.VISIBLE);
                setUpSat(schoolResponse);
            }else{
                mActivity.showAlertDialog(getString(R.string.error_dialog_message),"",
                        getString(R.string.error_dialog_refresh),getString(R.string.error_dialog_cancel));
            }
        };
        mViewModel.getSatScore(school.dbn).observe(getViewLifecycleOwner(),schoolObserver);

    }

    private void setUpSat(List<SatScoreJson> schoolResponse) {
        school.setNumOfSatTestTakers(schoolResponse.get(0).numOfSatTestTakers);
        school.setSatMathAvgScore(schoolResponse.get(0).satMathAvgScore);
        school.setSatCriticalReadingAvgScore(schoolResponse.get(0).satCriticalReadingAvgScore);
        school.setSatWritingAvgScore(schoolResponse.get(0).satWritingAvgScore);
        setUpView();
    }

    private void setUpView() {
        mBinding.llView.addView(SchoolUtils.getHeaderTextView(mActivity,school.schoolName));
        if(school.getRequirements().size() > 0){
            getAllViews((String) getText(R.string.dashboard_requirement),school.getRequirements(),true);
        }if(school.getEligibility().size() > 0){
            getAllViews((String) getText(R.string.dashboard_elegibility),school.getEligibility(),false);
        }
        getAllViews((String) getText(R.string.dashboard_sat_test_takers),
                Collections.singletonList(school.numOfSatTestTakers),false);
        getAllViews((String) getText(R.string.dashboard_sat_read_avg_score),
                Collections.singletonList(school.satCriticalReadingAvgScore),false);
        getAllViews((String) getText(R.string.dashboard_sat_math_avg_score),
                Collections.singletonList(school.satMathAvgScore),false);
        getAllViews((String) getText(R.string.dashboard_sat_writing_avg_score),
                Collections.singletonList(school.satWritingAvgScore),false);
        if(school.getOppturnity().size() > 0){
            getAllViews((String) getText(R.string.dashboard_oppturnity),school.getOppturnity(),true);
        }
        if(school.hasPrograms())
            getAllViews((String) getText(R.string.dashboard_programs),
                Collections.singletonList(school.ellPrograms),false);
        if(school.haslanguage())
            getAllViews((String) getText(R.string.dashboard_language),
                Collections.singletonList(school.languageClasses),false);
        if(school.hasAdvancementCourses())
            getAllViews((String) getText(R.string.dashboard_courses),
                Collections.singletonList(school.advancedplacementCourses),false);
        if(school.hasDiploma())
            getAllViews((String) getText(R.string.dashboard_diploma),
                Collections.singletonList(school.diplomaEndorsements),false);
        if(school.hasDirection())
            getAllViews((String) getText(R.string.dashboard_direction),
                Collections.singletonList(school.directions1),false);
        if(school.hasAddInfo())
            getAllViews((String) getText(R.string.dashboard_add_info),
                Collections.singletonList(school.addtlInfo1),false);
    }

    private void getAllViews(String text, List<String> values, boolean isIncrement) {

        int i =1;
        for (String val : values){
            String header = "";
            LinearLayout linearLayout = new LinearLayout(mActivity);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0, SchoolUtils.getDp(mActivity,10), 0, 0);
            linearLayout.setLayoutParams(params);
            header = isIncrement? text+" " + i :text;
            linearLayout.addView(SchoolUtils.getSubHeaderTextView(mActivity,header));
            linearLayout.addView(SchoolUtils.getNormalTextView(mActivity," : "));
            linearLayout.addView(SchoolUtils.getNormalTextView(mActivity,val));
            i++;
            mBinding.llView.addView(linearLayout);
        }
    }

    public void onPositiveClick() {
        getData();
    }
}
