package com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.view.splash;


import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.databinding.ActivityMainBinding;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.view.BaseActivity;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.view.dashboard.activity.DashboardActivity;


public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private ActivityMainBinding mBinding;
    public int timerforprogressbar = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();
        intializeView();
    }

    private void intializeView() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                openAndClearStack(DashboardActivity.class);
            }

        }, timerforprogressbar);
    }
}