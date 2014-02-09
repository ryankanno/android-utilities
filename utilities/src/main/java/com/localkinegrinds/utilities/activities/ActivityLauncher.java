package com.localkinegrinds.utilities.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

public final class ActivityLauncher {

    private static final String TAG = ActivityLauncher.class.getName();
    private final Activity activity;

    public ActivityLauncher(Activity launcher) {
        this.activity = launcher;
    }

    public void startActivity(final Intent intent)
    {
        startActivity(intent, 0);
    }

    public void startActivity(final Intent intent, final int delayMillis) {
        Log.v(TAG, "Calling startActivity on " + intent.toString() + " in " + delayMillis + " milliseconds");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                activity.finish();
                activity.startActivity(intent);
            }
        }, delayMillis);
    }
}
