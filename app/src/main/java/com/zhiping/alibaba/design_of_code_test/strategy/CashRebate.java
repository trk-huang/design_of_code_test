package com.zhiping.alibaba.design_of_code_test.strategy;

/**
 * Created by huangdaju on 17/8/7.
 * 折扣类
 */

public class CashRebate implements CashStrategy {
    private double rebate;

    public CashRebate(double rebate) {
        this.rebate = rebate;
    }

    @Override
    public double acceptCash(double money) {
        return rebate * money / 10f;
    }
}
