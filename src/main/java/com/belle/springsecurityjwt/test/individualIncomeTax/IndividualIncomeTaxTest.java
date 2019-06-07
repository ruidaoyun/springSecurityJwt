package com.belle.springsecurityjwt.test.individualIncomeTax;

import java.util.ArrayList;

/**
 * @author: rui.dy
 * @date: 2019/5/15
 * @description:
 */
public class IndividualIncomeTaxTest {
    public static void main(String[] args) {
        ArrayList<IncomeBeforeTax> incomeBeforeTaxes=new ArrayList<> ();
        ArrayList<IncomeAfterTax> incomeAfterTaxs=new ArrayList<> ();
        //设置每个月的工资
        int i = 1;
        for (;i<3;i++){
            IncomeBeforeTax incomeBeforeTax=new IncomeBeforeTax (i, 8900,  7100, 0);
            incomeBeforeTaxes.add (incomeBeforeTax);
        }
        for (;i<13;i++){
            IncomeBeforeTax incomeBeforeTax=new IncomeBeforeTax (i, 8900,  7100, 1600);
            incomeBeforeTaxes.add (incomeBeforeTax);
        }
        double sumSalary = 0;
        double sumHouseRenting = 0;
        double sumPaid = 0;
        double sumInsurance=0;
        double sumReduce =0;
        for (IncomeBeforeTax incomeBeforeTax : incomeBeforeTaxes) {
            sumSalary+=incomeBeforeTax.getSalary ();
            sumHouseRenting+=incomeBeforeTax.getHouseRenting ();
            sumInsurance +=incomeBeforeTax.getBaseSalary ()* incomeBeforeTax.getPercent ();
            sumReduce+=5000;
            //计算当月应当缴税金额
            double needPay=sumSalary  - sumReduce - sumHouseRenting - sumInsurance;
            BaseTax baseTax=new BaseTax (needPay);
            //计算出当月应当扣除金额
            double tax=needPay * baseTax.getPercent () - baseTax.getReduce () - sumPaid;
            sumPaid+=tax;
            IncomeAfterTax incomeAfterTax=new IncomeAfterTax ();
            incomeAfterTax.setSalary (incomeBeforeTax.getSalary ());
            incomeAfterTax.setMonth (incomeBeforeTax.getMonth ());
            incomeAfterTax.setTax (tax);
            incomeAfterTax.setSumPaid (sumPaid);
            incomeAfterTax.setSumSalary (sumSalary);
            incomeAfterTax.setSumHouseRenting (sumHouseRenting);
            incomeAfterTax.setSumInsurance (sumInsurance);
            incomeAfterTax.setIncome (incomeBeforeTax.getSalary ()-incomeBeforeTax.getBaseSalary ()* incomeBeforeTax.getPercent ()-tax);
            incomeAfterTaxs.add (incomeAfterTax);
        }
        System.out.println (incomeAfterTaxs);

    }
    static class BaseTax{
        //税率
        private double percent;
        //速算扣除
        private double reduce;

        public double getPercent() {
            return percent;
        }

        public BaseTax setPercent(double percent) {
            this.percent=percent;
            return this;
        }

        public double getReduce() {
            return reduce;
        }

        public BaseTax setReduce(double reduce) {
            this.reduce=reduce;
            return this;
        }

        public BaseTax(double needPay){
            if (needPay<=36000){
                this.percent = 0.03;
                this.reduce = 0;
            }else if (needPay>36000&&needPay<=144000){
                this.percent = 0.1;
                this.reduce = 2520;
            }else if (needPay>144000&&needPay<=300000){
                this.percent = 0.2;
                this.reduce = 16920;
            }else if (needPay>300000&&needPay<=420000){
                this.percent = 0.25;
                this.reduce = 31920;
            }else if (needPay>420000&&needPay<=660000){
                this.percent = 0.3;
                this.reduce = 52920;
            }else if (needPay>660000&&needPay<=960000){
                this.percent = 0.35;
                this.reduce = 85920;
            }else if (needPay>960000){
                this.percent = 0.45;
                this.reduce = 181920;
            }

        }
    }
}
