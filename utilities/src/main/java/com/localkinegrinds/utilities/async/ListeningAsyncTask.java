package com.localkinegrinds.utilities.async;

import android.os.AsyncTask;

public abstract class ListeningAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

    protected AsyncTaskListener<Result> asyncTaskListener;

    public ListeningAsyncTask(AsyncTaskListener<Result> asyncTaskListener) {
        super();
        this.asyncTaskListener = asyncTaskListener;
    }

    @Override
    protected void onPostExecute(Result result) {
        super.onPostExecute(result);
        asyncTaskListener.onTaskComplete(result);
    }
}
