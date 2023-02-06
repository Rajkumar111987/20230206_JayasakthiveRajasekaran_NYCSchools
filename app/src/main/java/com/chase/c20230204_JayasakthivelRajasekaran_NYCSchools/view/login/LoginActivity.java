package com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.view.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.databinding.ActivityLoginBinding;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.view.BaseActivity;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.view.splash.MainActivity;

public class LoginActivity extends BaseActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        ActivityLoginBinding mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.siginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAndClearStack(MainActivity.class);
            }
        });

    }
}
