package com.belle.springsecurityjwt.test.individualIncomeTax;

/**
 * @author: rui.dy
 * @date: 2019/5/15
 * @description:
 */
public class IncomeAfterTax {
    //月份
    private int month;
    //税前
    private double salary;
    //税后
    private double income;
    //个税金额
    private double tax;
    //累计税前工资
    private double sumSalary=0;
    //累计租房专项扣除
    private double sumHouseRenting=0;
    //累计已扣除
    private double sumPaid=0;
    //累积五险一金
    private double sumInsurance=0;

    @Override
    public String toString() {
        return  "\n"+month +"月需缴纳金额如下"+
                "\n税前工资:" + String.format("%.2f", salary) +
                "\n税后工资:" + String.format("%.2f",income) +
                "\n个税:" + String.format("%.2f",tax) +
                "\n总计税前工资:" + String.format("%.2f",sumSalary) +
                "\n总计缴纳个税:" + String.format("%.2f",sumPaid) +
                "\n总计五险一金金额:" + String.format("%.2f",sumInsurance)+"\n";
    }

    public double getSumInsurance() {
        return sumInsurance;
    }

    public IncomeAfterTax setSumInsurance(double sumInsurance) {
        this.sumInsurance=sumInsurance;
        return this;
    }

    public int getMonth() {
        return month;
    }

    public IncomeAfterTax setMonth(int month) {
        this.month=month;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public IncomeAfterTax setSalary(double salary) {
        this.salary=salary;
        return this;
    }

    public double getIncome() {
        return income;
    }

    public IncomeAfterTax setIncome(double income) {
        this.income=income;
        return this;
    }

    public double getTax() {
        return tax;
    }

    public IncomeAfterTax setTax(double tax) {
        this.tax=tax;
        return this;
    }

    public double getSumSalary() {
        return sumSalary;
    }

    public IncomeAfterTax setSumSalary(double sumSalary) {
        this.sumSalary=sumSalary;
        return this;
    }

    public double getSumHouseRenting() {
        return sumHouseRenting;
    }

    public IncomeAfterTax setSumHouseRenting(double sumHouseRenting) {
        this.sumHouseRenting=sumHouseRenting;
        return this;
    }

    public double getSumPaid() {
        return sumPaid;
    }

    public IncomeAfterTax setSumPaid(double sumPaid) {
        this.sumPaid=sumPaid;
        return this;
    }
}
