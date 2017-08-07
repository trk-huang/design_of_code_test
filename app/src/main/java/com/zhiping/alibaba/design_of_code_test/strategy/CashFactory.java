package com.zhiping.alibaba.design_of_code_test.strategy;

/**
 * Created by huangdaju on 17/8/7.
 */

public class CashFactory {

    private int cashType;

    public static CashStrategy cashContext(int cashType) {
        CashStrategy cashStrategy = null;
        switch (cashType) {
            case 0: //原价
                cashStrategy = new CashNormal();
                break;
            case 1: //折扣
                cashStrategy = new CashRebate(7.5);
                break;
            case 2: //满返
                cashStrategy = new CashReturn(300, 100);
                break;
        }
        return cashStrategy;
    }
}
