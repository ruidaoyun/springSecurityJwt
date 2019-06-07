package com.belle.springsecurityjwt.test;

import com.belle.springsecurityjwt.utils.DateUtil;

import java.math.BigDecimal;

public class DateTest {
    public static void main(String[] args) {
        String strBeginDate = DateUtil.formatDateByFormat(DateUtil.getCurrentDateTime(), "yyyy-MM") + "-01"; //request.getParameter("in_BeginDate");
        String strEndDate = DateUtil.formatDateByFormat(DateUtil.addMonth(DateUtil.getCurrentDateTime(), 1), "yyyy-MM")
                + "-01";
        System.out.println (strBeginDate);
        System.out.println (strEndDate);
        System.out.println (new BigDecimal ("12").toBigInteger ());
    }
}
