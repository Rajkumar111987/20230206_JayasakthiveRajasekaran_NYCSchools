package com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.view.dashboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.R;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.databinding.ViewSchoolAdapterBinding;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.model.HighSchoolsJson;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.utils.SchoolUtils;
import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.view.dashboard.activity.DashboardActivity;

import java.util.List;

public class RecyclerViewSchoolAdapter extends RecyclerView.Adapter<RecyclerViewSchoolAdapter.ViewHolder> {

    private final List<HighSchoolsJson> list;
    private static ClickListener clickListener;
    private final Context mContext;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewSchoolAdapterBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.view_school_adapter, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        RecyclerViewSchoolAdapter.clickListener = clickListener;
    }

    public RecyclerViewSchoolAdapter(Context context, List<HighSchoolsJson> mList ) {
        mContext = context;
        this.list = mList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewSchoolAdapterBinding itemRowBinding;

        public ViewHolder(ViewSchoolAdapterBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(HighSchoolsJson obj) {
            itemRowBinding.setHighSchool(obj);
            itemRowBinding.executePendingBindings();
            itemRowBinding.info.setOnClickListener(v -> ((DashboardActivity)mContext).
                    showAlertDialogNoAction(list.get(getBindingAdapterPosition()).
                            overviewParagraph,list.get(getBindingAdapterPosition()).schoolName));
            itemRowBinding.ivWeb.setOnClickListener(v ->
                            SchoolUtils.showWebView(mContext , list.get(getBindingAdapterPosition()).getWebsite()));

            itemRowBinding.ivPhone.setOnClickListener(v ->
                SchoolUtils.showPhone((DashboardActivity)mContext , list.get(getBindingAdapterPosition()).phoneNumber));

            itemRowBinding.ivEmail.setOnClickListener(v ->
                SchoolUtils.showEmail(mContext , list.get(getBindingAdapterPosition()).schoolEmail));

            itemRowBinding.ivDirection.setOnClickListener(v ->
                SchoolUtils.showDirections(mContext , list.get(getBindingAdapterPosition()).latitude,list.get(getBindingAdapterPosition()).longitude));

            itemRowBinding.clView.setOnClickListener(v ->
                    clickListener.onItemClick(getBindingAdapterPosition(),v));
        }
    }
}
