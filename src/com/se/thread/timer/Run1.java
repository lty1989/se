package com.se.thread.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Run1 {
    private static Timer timer = new Timer();

    static class MyTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("运行了 ，时间为" + new Date());
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2017-10-11 13:20:00";
        try {
            Date date = sdf.parse(dateString);
            timer.schedule(task, date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
