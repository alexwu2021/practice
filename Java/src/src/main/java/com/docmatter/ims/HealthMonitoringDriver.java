package com.docmatter.ims;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class HealthMonitoringDriver extends TimerTask {

    private static final int NUMBER_OF_MS_FOR_NEXT_HEALTH_LOG = 5 * 1000;

    public HealthMonitoringDriver() {
        Timer timer = new Timer();
        int period = NUMBER_OF_MS_FOR_NEXT_HEALTH_LOG;
        System.out.println("setting for writing to health monitoring log file interval is set at " + period/1000 + " seconds");
        timer.scheduleAtFixedRate(this, new Date(), period);
    }
    public void run() {
        //HealthMonitoringManager.me().writeToHealthMonitoringLogFile();
        System.out.println("HealthMonitoringDriver is running, for now doing nothing");
    }
}



