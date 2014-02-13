package com.localkinegrinds.utilities.notification;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

public final class Toastie {

    private static final String TAG = Toastie.class.getName();

    private static void show(final Activity activity, final int resId, final int duration) {
        if (null == activity)
            return;

        Log.d(TAG, "Trying to display a Toast notification using resource id: " + resId);

        final Context context = activity.getApplication();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(context, resId, duration).show();
            }
        });
    }

    private static void show(final Activity activity, final String message, final int duration) {
        if (null == activity)
            return;

        if (TextUtils.isEmpty(message))
            return;

        Log.d(TAG, "Trying to display a Toast notification: " + message);

        final Context context = activity.getApplication();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(context, message, duration).show();
            }
        });
    }
}
