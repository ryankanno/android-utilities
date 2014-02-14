package com.localkinegrinds.utilities.concurrent;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory implements ThreadFactory {

    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final String threadPrefix;
    private final int threadPriority;

    public NamedThreadFactory(String threadPrefix) {
        this(threadPrefix, Thread.NORM_PRIORITY);
    }

    public NamedThreadFactory(String threadPrefix, int threadPriority) {
        SecurityManager s = System.getSecurityManager();
        this.group = (null != s) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.threadPriority = threadPriority;
        this.threadPrefix = threadPrefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(this.group, r, new StringBuilder(this.threadPrefix).append("-Thread-").append(threadNumber.getAndIncrement()).toString(), 0);
        t.setPriority(this.threadPriority);
        return t;
    }
}
