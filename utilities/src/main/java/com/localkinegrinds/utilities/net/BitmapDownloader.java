package com.localkinegrinds.utilities.net;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.AndroidHttpClient;
import android.os.Looper;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BitmapDownloader implements Downloader<Bitmap> {

    private static final String TAG = BitmapDownloader.class.getName();

    private final HttpClient client;

    public BitmapDownloader() {
        this.client = getHttpClient();
    }

    private HttpClient getHttpClient()  {
        return (Looper.getMainLooper().getThread() == Thread.currentThread()) ?
            new DefaultHttpClient() : AndroidHttpClient.newInstance("Android");
    }

    public Bitmap download(String url) {
        final HttpGet getRequest = new HttpGet(url);

        try {
            HttpResponse response = this.client.execute(getRequest);
            final int statusCode = response.getStatusLine().getStatusCode();

            if (HttpStatus.SC_OK != statusCode) {
                Log.w(TAG, "HTTP Error " + statusCode + " downloading from " + url);
                return null;
            }

            final HttpEntity entity = response.getEntity();

            if (null != entity)
            {
                InputStream is = null;
                try {
                    is = entity.getContent();
                    return BitmapFactory.decodeStream(new BufferedInputStream(is));
                } finally {
                    if (null != is) {
                        is.close();
                    }
                    entity.consumeContent();
                }
            }
        } catch (IOException e) {
            getRequest.abort();
            Log.w(TAG , "IO Error downloading from " + url, e);
        } catch (IllegalStateException e) {
            getRequest.abort();
            Log.w(TAG , "Error downloading from " + url, e);
        } catch (Exception e) {
            getRequest.abort();
            Log.w(TAG , "Error downloading from " + url, e);
        } finally {
            if ((client instanceof AndroidHttpClient)) {
                ((AndroidHttpClient) client).close();
            }
        }
        return null;
    }
}
