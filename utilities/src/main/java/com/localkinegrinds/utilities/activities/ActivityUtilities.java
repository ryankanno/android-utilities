package com.localkinegrinds.utilities.activities;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

public class ActivityUtilities {

    private static final String TAG = ActivityUtilities.class.getName();

    public static void goHome(final Activity currentActivity, final Class<?> homeActivityClass) {
        Log.d(TAG, "Attempting to go to Home activity: " + homeActivityClass.toString());
        final Intent intent = new Intent(currentActivity, homeActivityClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        new ActivityLauncher(currentActivity).startActivity(intent);
    }
}
