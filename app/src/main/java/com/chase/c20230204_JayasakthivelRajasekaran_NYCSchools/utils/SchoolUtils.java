package com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.R;

import java.util.Locale;

public class SchoolUtils {

    public static View getHeaderTextView(Context context , String text) {
        TextView view = new TextView(context);
        view.setText(text);
        view.setTextColor(context.getColor(R.color.white));
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
        view.setTypeface(view.getTypeface(), Typeface.BOLD);
        view.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        return view;
    }

    public static int getDp(Context context, int dp){
        Resources resources = context.getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                resources.getDisplayMetrics()
        );
        return px;
    }

    public static View getSubHeaderTextView(Context context , String text) {
        TextView view = new TextView(context);
        view.setText(text);
        view.setTextColor(context.getColor(R.color.white));
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        view.setLayoutParams(new ViewGroup.LayoutParams(
                getDp(context,120),
                ViewGroup.LayoutParams.WRAP_CONTENT));
        return view;
    }

    public static View getNormalTextView(Context context , String text) {
        TextView view = new TextView(context);
        view.setText(text);
        view.setTextColor(context.getColor(R.color.white));
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        return view;
    }

    public static void showWebView(Context mContext, String url){
        mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    public static void showPhone(Activity mActivity, String number){
        if (ContextCompat.checkSelfPermission(mActivity,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(mActivity,
                    new String[]{Manifest.permission.CALL_PHONE},
                    1908);
        } else {
            //You already have permission
            try {
                mActivity.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+number)));
            } catch(SecurityException e) {
                e.printStackTrace();
            }
        }
    }

    public static void showEmail(Context mContext, String email){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{email});
        i.putExtra(Intent.EXTRA_SUBJECT, "School Enquiry");
        try {
            mContext.startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(mContext, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    public static void showDirections(Context mContext, String latitude, String longitude){
        String uri = String.format(Locale.ENGLISH, "geo:%s,%s", latitude, longitude);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        mContext.startActivity(intent);
    }
}
