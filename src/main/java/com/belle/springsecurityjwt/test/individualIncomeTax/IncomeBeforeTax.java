package com.belle.springsecurityjwt.test.individualIncomeTax;

/**
 * @author: rui.dy
 * @date: 2019/5/15
 * @description:
 */
public class IncomeBeforeTax {
    //月份
    private int month;
    //收入
    private double salary;
    //五险一金缴纳基数
    private double baseSalary;
    //五险一金缴纳比例(上海)
    private double percent = 0.175;
    //租房专向扣除
    private double houseRenting;


    public IncomeBeforeTax(int month,double salary, double baseSalary, double houseRenting) {
        this.month=month;
        this.salary=salary;
        this.baseSalary=baseSalary;
        this.houseRenting=houseRenting;
    }

    public double getSalary() {
        return salary;
    }

    public IncomeBeforeTax setSalary(double salary) {
        this.salary=salary;
        return this;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public IncomeBeforeTax setBaseSalary(double baseSalary) {
        this.baseSalary=baseSalary;
        return this;
    }

    public double getPercent() {
        return percent;
    }

    public IncomeBeforeTax setPercent(double percent) {
        this.percent=percent;
        return this;
    }

    public double getHouseRenting() {
        return houseRenting;
    }

    public IncomeBeforeTax setHouseRenting(double houseRenting) {
        this.houseRenting=houseRenting;
        return this;
    }

    public int getMonth() {
        return month;
    }

    public IncomeBeforeTax setMonth(int month) {
        this.month=month;
        return this;
    }

}
