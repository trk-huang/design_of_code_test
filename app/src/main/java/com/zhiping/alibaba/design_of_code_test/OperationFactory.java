package com.zhiping.alibaba.design_of_code_test;

/**
 * Created by huangdaju on 17/8/1.
 */

public class OperationFactory {

    public static Operation createOperation(String operate) {
        Operation op = null;
        if ("+".equals(operate)) {
            op = new OperationAdd();
        } else if ("-".equals(operate)) {
            op = new OperationSub();
        } else if ("*".equals(operate)) {
            op = new OperationMul();
        } else if ("/".equals(operate)) {
            op = new OperationDiv();
        }
        return op;
    }
}
