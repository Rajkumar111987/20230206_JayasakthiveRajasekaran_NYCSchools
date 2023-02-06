package com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.view.dashboard.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.R;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.databinding.FragmentDashboardListBinding;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.model.HighSchoolsJson;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.utils.FragmentScreenNavigation;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.view.dashboard.activity.DashboardActivity;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.view.dashboard.adapter.RecyclerViewSchoolAdapter;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.viewModel.SchoolViewModel;

import java.util.Collections;
import java.util.List;


public class DashboardListFragment extends Fragment {

    public static final String TAG = DashboardListFragment.class.getSimpleName();
    private DashboardActivity mActivity;
    private FragmentDashboardListBinding mBinding;
    public SchoolViewModel mViewModel;
    private LinearLayoutManager layoutManager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        mBinding = FragmentDashboardListBinding.inflate(inflater,container,false);
        intializeView();
        return mBinding.getRoot();

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void intializeView() {
        mActivity = (DashboardActivity) requireActivity();
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(mActivity.getApplication()).create(SchoolViewModel.class);
        setHasOptionsMenu(true);
        getData();

        /*To show FAB after some scroll of recycler view*/
        mBinding.rcView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = layoutManager.getChildCount();
                int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();
                if ((pastVisibleItems + visibleItemCount > 6)) {
                    mBinding.fabAdd.show();
                } else {
                    mBinding.fabAdd.hide();
                }
            }
        });

        /*To show FAB after some scroll of recycler view
        * once its scrolled to little below
        * on click of fab it will take the user to top position again*/
        mBinding.fabAdd.setOnClickListener(v -> {
            mBinding.rcView.setFocusableInTouchMode(true);
            mBinding.rcView.smoothScrollToPosition(0);
            mBinding.rcView.smoothScrollBy(0,0);
        });

    }

    private void getData() {

        mBinding.progressbar.show();
        final Observer<List<HighSchoolsJson>> schoolObserver = schoolResponse ->{
            mBinding.progressbar.hide();
            if(schoolResponse.size() > 0){
                mActivity.mSchools = schoolResponse;
                showSchoolList(schoolResponse);
            }else{
                mActivity.showAlertDialog(getString(R.string.error_dialog_message),"",
                        getString(R.string.error_dialog_refresh),getString(R.string.error_dialog_exit));
            }
        };
        mViewModel.getAllHighSchool().observe(getViewLifecycleOwner(),schoolObserver);
    }

    @SuppressLint("NotifyDataSetChanged")
    private void showSchoolList(List<HighSchoolsJson> lists){
        RecyclerViewSchoolAdapter adapter = new RecyclerViewSchoolAdapter(getContext(),lists);
        adapter.setOnItemClickListener((position, v) -> mActivity.setScreenData(position, FragmentScreenNavigation.DASHBOARD_DETAIL_CUSTOM));

        layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false);
        mBinding.rcView.setNestedScrollingEnabled(false);
        mBinding.rcView.setLayoutManager(layoutManager);
        mBinding.rcView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    public void onPositiveClick() {
        getData();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_sort,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_sort:{
                showDialog();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void showDialog(){
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(mActivity);
        builderSingle.setTitle("Sort The List");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(mActivity, android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add("Sort School Name By A-Z");
        arrayAdapter.add("Sort School Name By Z-A");
        arrayAdapter.add("Sort by Attendance");
        arrayAdapter.add("Sort city by A-Z");
        arrayAdapter.add("Sort city by Z-A");

        builderSingle.setNegativeButton("cancel", (dialog, which) -> dialog.dismiss());

        builderSingle.setAdapter(arrayAdapter, (dialog, which) -> {
            String strName = arrayAdapter.getItem(which);
            Log.d(TAG,strName);
            sortList(which);
        });
        builderSingle.show();
    }

    private void sortList(int which) {
        switch (which){
            case 0:{
                Collections.sort(mActivity.mSchools, (o1, o2) -> (o1.schoolName.compareTo(o2.schoolName)));

                showSchoolList(mActivity.mSchools);
                break;
            }
            case 1:{
                Collections.sort(mActivity.mSchools, (o1, o2) -> (o2.schoolName.compareTo(o1.schoolName)));

                showSchoolList(mActivity.mSchools);
                break;
            }

            case 2:{
                Collections.sort(mActivity.mSchools, (o1, o2) -> (o2.attendanceRate.compareTo(o1.attendanceRate)));

                showSchoolList(mActivity.mSchools);
                break;
            }

            case 3:{
                Collections.sort(mActivity.mSchools, (o1, o2) -> (o1.city.compareTo(o2.city)));

                showSchoolList(mActivity.mSchools);
                break;
            }

            case 4:{
                Collections.sort(mActivity.mSchools, (o1, o2) -> (o2.city.compareTo(o1.city)));

                showSchoolList(mActivity.mSchools);
                break;
            }
        }
    }
}
