package com.schedule;

import java.sql.Connection;

import java.sql.Statement;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;


public class Scheduler {
    public synchronized void runSchedule(SchedulePOJO sP1) {
        final SchedulePOJO sP = sP1;
        final ScheduledExecutorService serv =
            Executors.newSingleThreadScheduledExecutor();

        Runnable runnable = new Runnable() {
            public void start() {
            }

            public void run() {
                Connection con = null;
                Statement stmt = null;
                if (sP.isStopStat()) {
                    serv.shutdown();
                    try {
                        Context ctx = new InitialContext();
                        DataSource ds = (DataSource)ctx.lookup(sP.getDbSrc());
                        con = ds.getConnection();
                        String query =
                            "update  XXFND_SCHEDULE_T  " + "set   RUN_STATUS = 'N' ";
                        stmt = con.createStatement();
                        int i = stmt.executeUpdate(query);
                    } catch (Exception e) {
                        System.err.println("Exception in StopScheduler : " +
                                           e);
                    } finally {
                        try {
                            if (stmt != null) {
                                stmt.close();
                            }
                            if (con != null) {
                                con.close();
                            }
                        } catch (Exception e) {
                            System.err.println("Exception in StopScheduler finally : ");
                        }
                    }
                    serv.shutdown();
                    System.err.println("!!!!!!!!!!!Shut down executed!!!!!!!!!!!!");
                    try {
                        serv.awaitTermination(0, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        System.err.println("Interruption occured " +
                                           new Date());
                    }
                    System.gc();
                } else {
                    GenInvoke gi = new GenInvoke();
                    gi.processData(sP);
                    long ONE_MINUTE_IN_MILLIS = 60000;
                    Calendar date = Calendar.getInstance();
                    long t = date.getTimeInMillis();
                    Date d =
                        new Date(t + (sP.getBackOff() * ONE_MINUTE_IN_MILLIS));
                    System.err.println("Next Execution on : " + d);
                }
            }
        };
        if (!sP.isStopStat()) {
            serv.scheduleWithFixedDelay(runnable, 0, sP.getBackOff(),
                                        TimeUnit.MINUTES);
        }

    }
}
