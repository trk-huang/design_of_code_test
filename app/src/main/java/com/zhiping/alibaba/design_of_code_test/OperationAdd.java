package com.zhiping.alibaba.design_of_code_test;

/**
 * Created by huangdaju on 17/8/1.
 */

public class OperationAdd extends Operation {
    @Override
    public double getResult() {
        return getNumberA() + getNumberB();
    }
}
