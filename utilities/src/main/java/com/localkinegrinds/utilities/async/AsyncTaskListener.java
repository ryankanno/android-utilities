package com.localkinegrinds.utilities.async;

interface AsyncTaskListener<T> {
    public void onTaskComplete(T result);
}
