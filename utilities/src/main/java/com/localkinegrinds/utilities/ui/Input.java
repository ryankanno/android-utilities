package com.localkinegrinds.utilities.ui;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public final class Input {

    private static final String TAG = Input.class.getName();

    public final static void clearEditTextFields(ViewGroup group) {
        setEditTextFields(group, "");
    }

    private final static void setEditTextFields(ViewGroup group, String text) {
        if (null != group) {
            for (int i = 0, count = group.getChildCount(); i < count; ++i) {
                View view = group.getChildAt(i);
                if (view instanceof EditText) {
                    Log.d(TAG, "Setting text of EditText field to " + text);
                    ((EditText)view).setText(text);
                }

                if (view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0)) {
                    setEditTextFields((ViewGroup)view, text);
                }
            }
        }
    }
}
