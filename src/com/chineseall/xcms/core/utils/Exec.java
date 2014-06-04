package com.chineseall.xcms.core.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Exec {

    private static ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
    
    /**
     * 用法及参数参见 {@link java.util.concurrent.ScheduledExecutorService
     * #schedule(Runnable, long, TimeUnit) schedule()}
     */
    public static ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
        
        return exec.schedule(command, delay, unit);
    }
    
    /**
     * 用法及参数参见 {@link java.util.concurrent.ScheduledExecutorService
     * #scheduleAtFixedRate(Runnable, long, long, TimeUnit) scheduleAtFixedRate()}
     */
    public static ScheduledFuture<?> scheduleAtFixedRate(Runnable command, 
            long initialDelay, long period, TimeUnit unit) {
        
        return exec.scheduleAtFixedRate(command, initialDelay, period, unit);
    }
    
    /**
     * 用法及参数参见 {@link java.util.concurrent.ScheduledExecutorService
     * #scheduleWithFixedDelay(Runnable, long, long, TimeUnit) scheduleWithFixedDelay}
     */
    public static ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, 
            long initialDelay, long delay, TimeUnit unit) {
        
        return exec.scheduleWithFixedDelay(command, initialDelay, delay, unit);
    }
}
