package com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.App;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.R;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.utils.FragmentScreenNavigation;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.viewModel.FragmentTransitionViewModel;


public class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();

    public static App app;
    public Fragment navFragment;

    public static final String SCHOOL = "School";
    public FragmentTransitionViewModel mFragViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");

        app = (App) getApplication();
    }

    /*This has to be override in the activity for navigation*/
    public void onShowNextFragment(FragmentScreenNavigation screenNavigation){}

    /*This we need to call from activity which need screen navigation for fragments*/
    public void intializeFragmentTrans(){
        mFragViewModel = new ViewModelProvider(this).get(FragmentTransitionViewModel.class);
        final Observer<FragmentScreenNavigation> fragmentScreenNavigationObserver = fragScreenResponse ->{
            if(fragScreenResponse != null){
                onShowNextFragment(fragScreenResponse);
            }
        };
        mFragViewModel.getScreenNav().observe(this,fragmentScreenNavigationObserver);
    }

    public void showAlertDialog(String message, String header,String positive) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(header);
        builder.setMessage(message);
        builder.setPositiveButton(positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                onPositiveClick();

            }
        }).show();

    }

    public void showAlertDialogNoAction(String message, String header) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(header);
        builder.setMessage(message);
        builder.setPositiveButton(getText(R.string.error_dialog_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();

    }

    public void openAndClearStack(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    public void showAlertDialog(String message, String header,String positive,String negative) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(header);
        builder.setMessage(message);
        builder.setNegativeButton(negative,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                onNegativeClick();

            }
        }).setPositiveButton(positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                onPositiveClick();

            }
        }).show();

    }

    public void onPositiveClick(){}
    public void onNegativeClick(){}

    /**
     * Displays requested fragment with basic animations
     */
    public int showFragment(Fragment fragment, Bundle args, int layoutId, boolean addToBackStack,
                            String fragmentTag) {
        return showFragment(fragment, args, layoutId, addToBackStack, R.anim.fade_in,
                R.anim.fade_out, R.anim.slide_from_left_to_center,
                R.anim.slide_from_center_to_right, fragmentTag);
    }

    /**
     * Displays requested fragment.
     *
     * @param fragment to be displayed
     * @param args     any arguments applicable to the fragment
     * @return the fragment identifier for the new fragment - useful for
     * backstack navigation
     */
    public int showFragment(Fragment fragment, Bundle args, int layoutId, boolean addToBackStack,
                            int enterAnim, int exitAnim, int popEnterAnim, int popExitAnim,
                            String fragmentTag) {
        Log.d(TAG, "showFragment - " + fragment.getClass().getSimpleName());

        return showChildFragment(getSupportFragmentManager(), fragment, args, layoutId,
                addToBackStack, enterAnim, exitAnim, popEnterAnim, popExitAnim, fragmentTag);
    }

    public int showAddFragment(Fragment fragment, Bundle args, int layoutId, boolean addToBackStack,
                               int enterAnim, int exitAnim, int popEnterAnim, int popExitAnim,
                               String fragmentTag) {
        Log.d(TAG, "showFragment - " + fragment.getClass().getSimpleName());

        return showChildAddFragment(getSupportFragmentManager(), fragment, args, layoutId,
                addToBackStack, enterAnim, exitAnim, popEnterAnim, popExitAnim, fragmentTag);
    }

    /**
     * Displays requested fragment.
     *
     * @param fragment to be displayed
     * @param args     any arguments applicable to the fragment
     * @return the fragment identifier for the new fragment - useful for
     * backstack navigation
     */
    public int showChildFragment(FragmentManager fragmentManager, Fragment fragment, Bundle args,
                                 int layoutId, boolean addToBackStack, int enterAnim, int exitAnim,
                                 int popEnterAnim,
                                 int popExitAnim, String fragmentTag) {
        Log.d(TAG, "showChildFragment - " + fragment.getClass().getSimpleName());

        if (args != null)
            fragment.setArguments(args);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (enterAnim != 0) {
            transaction.setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim);
        }

        // replace whatever is in the fragment_container view with this
        // fragment
        if (fragmentTag == null)
            transaction.replace(layoutId, fragment);
        else
            transaction.replace(layoutId, fragment, fragmentTag);

        // add the transaction to the back stack so the user can navigate
        // back
        if (addToBackStack)
            transaction.addToBackStack(fragmentTag);

        // Commit the transaction
        if (!isFinishing()) {
            return transaction.commitAllowingStateLoss();
        } else {
            return -1;
        }
    }


    /**
     * Displays requested fragment.
     *
     * @param fragment to be displayed
     * @param args     any arguments applicable to the fragment
     * @return the fragment identifier for the new fragment - useful for
     * backstack navigation
     */
    public int showChildAddFragment(FragmentManager fragmentManager, Fragment fragment, Bundle args,
                                    int layoutId, boolean addToBackStack, int enterAnim, int exitAnim,
                                    int popEnterAnim,
                                    int popExitAnim, String fragmentTag) {
        Log.d(TAG, "showChildFragment - " + fragment.getClass().getSimpleName());

        if (args != null)
            fragment.setArguments(args);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (enterAnim != 0) {
            transaction.setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim);
        }

        // replace whatever is in the fragment_container view with this
        // fragment
        if (fragmentTag == null)
            transaction.add(layoutId, fragment);
        else
            transaction.add(layoutId, fragment, fragmentTag);

        // add the transaction to the back stack so the user can navigate
        // back
        if (addToBackStack)
            transaction.addToBackStack(fragmentTag);

        // Commit the transaction
        if (!isFinishing()) {
            return transaction.commitAllowingStateLoss();
        } else {
            return -1;
        }
    }


}
