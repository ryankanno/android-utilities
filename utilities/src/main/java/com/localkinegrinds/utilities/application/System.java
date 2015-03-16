package com.localkinegrinds.utilities.application;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

public final class System {

    private static final String TAG = System.class.getName();

    public final static String getVersionName(final Context context) {
        PackageInfo info = getPackageInfo(context);
        return (null != info) ? info.versionName : "";
    }

    protected final static PackageInfo getPackageInfo(final Context context)
    {
        try {
            PackageManager manager = context.getPackageManager();
            return manager.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
        } catch (PackageManager.NameNotFoundException nnfe) {
            Log.d(TAG, "Package name not found for context " + context, nnfe);
        } catch (Exception e) {
            Log.d(TAG, "Unexpected error occurred trying to get package info", e);
        }
        return null;
    }
}