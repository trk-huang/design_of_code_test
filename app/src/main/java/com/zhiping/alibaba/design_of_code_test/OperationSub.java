package com.zhiping.alibaba.design_of_code_test;

/**
 * Created by huangdaju on 17/8/1.
 */

public class OperationSub extends Operation {
    @Override
    public double getResult() {
        double result = 0;
        result = getNumberA() - getNumberB();
        return result;
    }
}
