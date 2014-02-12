package com.localkinegrinds.utilities.io;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class IOUtilities {

    private static final String TAG = IOUtilities.class.getName();

    private static final int DefaultBufferSize = 1024;

    public static int copy(InputStream input, OutputStream output) throws IOException {
        Log.d(TAG, "Copying input stream to an output stream");

        byte[] buffer = new byte[DefaultBufferSize];
        int numBytesCopied = 0;
        int numBytesRead = 0;
        while (-1 != (numBytesRead = input.read(buffer))) {
            output.write(buffer, 0, numBytesRead);
            numBytesCopied += numBytesRead;
        }
        return numBytesCopied;
    }

    public static void closeSilently(Closeable closeable)
    {
        if (null == closeable)
            return;

        try {
            closeable.close();
        } catch (Exception e) {
        }
    }
}