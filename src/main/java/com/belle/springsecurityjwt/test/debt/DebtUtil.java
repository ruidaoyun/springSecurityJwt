package com.belle.springsecurityjwt.test.debt;

/**
 * @author: rui.dy
 * @date: 2019/5/5
 * @description:
 */
public class DebtUtil {
    public static Debt getDebt(double money,int year,double yearRate){
        //单位万元转成元
        money = money* 10000;
        Debt debt=new Debt ();
        int month=12 * year;
        double monthRate=yearRate /12;
        //月还款额=本金*月利率*[(1+月利率)^n/[(1+月利率)^n-1]
        double monthPay = money*monthRate*(Math.pow (1+monthRate,month)/(Math.pow (1+monthRate,month)-1)); ;
        debt.setYear (year);
        debt.setMonth (month);
        debt.setDebt (money);
        debt.setMonthPay (monthPay);
        debt.setSumPay (monthPay*month);
        return debt;
    }
}
