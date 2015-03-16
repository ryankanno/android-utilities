package com.localkinegrinds.utilities.net;

/**
 * Created by ryankanno on 1/13/14.
 */
public interface Downloader<T> {
    public T download(String url);
}
