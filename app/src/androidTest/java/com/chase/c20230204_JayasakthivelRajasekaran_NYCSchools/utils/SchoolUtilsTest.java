package com.chase.c20230204_JayasakthivelRajasekaran_NYCSchools.utils;

import static org.junit.Assert.assertEquals;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class SchoolUtilsTest {

    @Test
    public void testGetHeaderTextView() {
        // Setup
        final Context context = null;

        // Run the test
        final View result = SchoolUtils.getHeaderTextView(context, "text");

        // Verify the results
    }

    @Test
    public void testGetDp() {
        // Setup
        final Context context = null;

        // Run the test
        final int result = SchoolUtils.getDp(context, 0);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testGetSubHeaderTextView() {
        // Setup
        final Context context = null;

        // Run the test
        final TextView result = (TextView) SchoolUtils.getSubHeaderTextView(context, "text");

        // Verify the results
        assertEquals("text",result.getText().toString());
    }

    @Test
    public void testGetNormalTextView() {
        // Setup
        final Context context = null;

        // Run the test
        final TextView result = (TextView) SchoolUtils.getNormalTextView(context, "text");

        // Verify the results
        assertEquals("text",result.getText().toString());
    }
}
