package com.localkinegrinds.utilities.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;


/**
 * Created by ryankanno on 1/13/14.
 */
public final class ActivityLauncher {

    private Activity activity;

    public ActivityLauncher(Activity launcher) {
        this.activity = launcher;
    }

    public void startActivity(final Intent intent)
    {
        startActivity(intent, 0);
    }

    public void startActivity(final Intent intent, int delayMillis) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                activity.startActivity(intent);
                activity.finish();
            }
        }, delayMillis);
    }
}
