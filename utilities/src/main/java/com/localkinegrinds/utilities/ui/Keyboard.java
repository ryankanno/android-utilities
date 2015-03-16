package com.localkinegrinds.utilities.ui;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public final class Keyboard {

    private static final String TAG = Keyboard.class.getName();

    public final static boolean hideSoftInput(final View view) {
        Log.d(TAG, "Attempting to hide soft keyboard input");

        if (null == view)
            return false;

        final Context context = view.getContext();

        if (null != context) {
            InputMethodManager manager = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (null != manager) {
                return manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }

        return false;
    }
}
