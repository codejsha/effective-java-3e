package org.example.demo.chapter11.item78.brokenstopthread;

import java.util.concurrent.TimeUnit;

// Broken! - How long would you expect this program to run?  (Page 312)
class StopThread {
    private static boolean stopRequested;

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
