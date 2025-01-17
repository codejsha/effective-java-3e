package org.example.demo.chapter11.item78.fixedstopthread1;

import java.util.concurrent.TimeUnit;

// Properly synchronized cooperative thread termination
class StopThread {
    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args)
            throws InterruptedException {
        var backgroundThread = new Thread(() -> {
            var i = 0;
            while (!stopRequested())
                i++;
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
