package com.xue.demo.guava.statusModel;

public class Demo {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        // 步骤1：投币2元（金额不足）
        machine.insertCoin(2);
        machine.selectProduct("可乐");  // 提示金额不足

        // 步骤2：再投币2元（足够购买）
        machine.insertCoin(2);
        machine.selectProduct("可乐");  // 选择成功，进入出货状态
        machine.dispense();  // 出货并找零

        // 步骤3：再次操作
        machine.selectProduct("雪碧");  // 提示先投币
        machine.insertCoin(5);
        machine.selectProduct("矿泉水");
        machine.dispense();  // 出货并找零3元
    }
}