package com.zhiping.alibaba.design_of_code_test.strategy;

/**
 * Created by huangdaju on 17/8/7.
 * 满多少返多少
 */

public class CashReturn implements CashStrategy {

    private double moneyCondition;
    private double moneyReturn;

    public CashReturn(float moneyCondition, float moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {
        if (money > moneyCondition)
            return money - moneyReturn;
        else
            return money;
    }
}
