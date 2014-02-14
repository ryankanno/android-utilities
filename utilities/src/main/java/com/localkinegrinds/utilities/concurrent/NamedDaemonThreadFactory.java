package com.localkinegrinds.utilities.concurrent;

public class NamedDaemonThreadFactory extends NamedThreadFactory {

    public NamedDaemonThreadFactory(String threadPrefix) {
        this(threadPrefix, Thread.NORM_PRIORITY);
    }

    public NamedDaemonThreadFactory(String threadPrefix, int threadPriority) {
        super(threadPrefix, threadPriority);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = super.newThread(r);
        t.setDaemon(true);
        return t;
    }
}
