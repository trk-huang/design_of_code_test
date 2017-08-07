package com.zhiping.alibaba.design_of_code_test.strategy;

/**
 * Created by huangdaju on 17/8/7.
 * 原价
 */

public class CashNormal implements CashStrategy {

    @Override
    public double acceptCash(double money) {
        return money;
    }
}
