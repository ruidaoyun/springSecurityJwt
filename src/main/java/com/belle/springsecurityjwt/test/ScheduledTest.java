package com.belle.springsecurityjwt.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTest {

    //@Scheduled(fixedRate = 2000)
    public void testPrint() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println ("hello world!"+dateFormat.format (new Date ()));
    }
}
