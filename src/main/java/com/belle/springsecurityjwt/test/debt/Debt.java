package com.belle.springsecurityjwt.test.debt;

/**
 * @author: rui.dy
 * @date: 2019/5/5
 * @description:
 */

public class Debt {
    private double debt;
    private int year;
    private int month;
    private double monthPay;
    private double sumPay;

    @Override
    public String toString() {
        //String.format("%.2f", d)
        return  "贷款明细"+
                "\n借款金额：" + debt +
                "\n借款年数：" + year +
                "\n借款月数：" + month +
                "\n每月还款金额：" + String.format("%.1f", monthPay) +
                "\n总共还款金额：" + String.format("%.1f", sumPay) ;
    }

    public int getMonth() {
        return month;
    }

    public Debt setMonth(int month) {
        this.month=month;
        return this;
    }

    public int getYear() {
        return year;
    }

    public Debt setYear(int year) {
        this.year=year;
        return this;
    }

    public double getDebt() {
        return debt;
    }

    public Debt setDebt(double debt) {
        this.debt=debt;
        return this;
    }

    public double getMonthPay() {
        return monthPay;
    }

    public Debt setMonthPay(double monthPay) {
        this.monthPay=monthPay;
        return this;
    }

    public double getSumPay() {
        return sumPay;
    }

    public Debt setSumPay(double sumPay) {
        this.sumPay=sumPay;
        return this;
    }
}
