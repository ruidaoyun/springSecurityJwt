package com.belle.springsecurityjwt.test;

import org.springframework.scheduling.annotation.Scheduled;

import java.awt.print.Printable;

public class SchedulingTest {
    public static void main(String[] args) {
        print ();
    }

    //@Scheduled(cron = "0/5 * * * * *")
    public static void print(){
        System.out.println ("currentTime"+System.currentTimeMillis ());
    }
}
