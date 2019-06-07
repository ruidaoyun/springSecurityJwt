package com.belle.springsecurityjwt.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatWeekTest {
    // 1,返回中文
    public static String getWeekday(String date) {// 必须yyyy-MM-dd
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdw = new SimpleDateFormat("E");
        Date d = null;
        try {
            d = sd.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sdw.format(d);
    }

    // 2，返回数字
    public static int dayForWeek(String pTime) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(pTime));
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }

    public static void main(String[] args) throws Exception {
        String weekday=getWeekday ("2018-10-19");
        System.out.println (weekday);
        System.out.println (dayForWeek ("2018-10-21"));
    }
}
