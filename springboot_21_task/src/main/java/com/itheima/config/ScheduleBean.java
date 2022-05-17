package com.itheima.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleBean {

    @Scheduled(cron = "0/1 * * * * ?")
    public void print() {
        System.out.println(Thread.currentThread().getName() + " spring task run...");
    }
}
