package com.xue.demo.guava.statusModel;

public class NoMoneyState implements VendingMachineState {
    private final VendingMachine machine;

    public NoMoneyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println("投入硬币：" + amount + "元");
        machine.setCurrentAmount(amount);
        machine.setCurrentState(machine.getHasMoneyState());
    }

    @Override
    public void selectProduct(String product) {
        System.out.println("请先投币！");
    }

    @Override
    public void dispense() {
        System.out.println("请先投币并选择商品！");
    }
}