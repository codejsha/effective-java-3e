package org.example.demo.chapter11.item78.fixedstopthread2;

import java.util.concurrent.TimeUnit;

// Cooperative thread termination with a volatile field
class StopThread {
    private static volatile boolean stopRequested;

    public static void main(String[] args)
            throws InterruptedException {
        var backgroundThread = new Thread(() -> {
            var i = 0;
            while (!stopRequested)
                i++;
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
