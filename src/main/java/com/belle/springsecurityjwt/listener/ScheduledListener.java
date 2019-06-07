/*
package com.belle.springsecurityjwt.listener;

import javafx.scene.input.DataFormat;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        testPrint ();
    }

    //@Scheduled(fixedRate = 2000)
    public void testPrint() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println ("hello world!"+dateFormat.format (new Date ()));
    }
}
*/
