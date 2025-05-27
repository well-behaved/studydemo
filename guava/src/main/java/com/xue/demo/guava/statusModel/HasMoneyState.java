package com.xue.demo.guava.statusModel;

public class HasMoneyState implements VendingMachineState {
    private final VendingMachine machine;

    public HasMoneyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(int amount) {
        int current = machine.getCurrentAmount();
        machine.setCurrentAmount(current + amount);
        System.out.println("累计投入：" + machine.getCurrentAmount() + "元");
    }

    @Override
    public void selectProduct(String product) {
        int price = machine.getProductPrice(product);
        if (price <= 0) {
            System.out.println("商品不存在：" + product);
            return;
        }

        if (machine.getCurrentAmount() >= price) {
            System.out.println("选择商品：" + product);
            machine.setSelectedProduct(product);
            machine.setCurrentState(machine.getDispensingState());
        } else {
            System.out.println("金额不足，还差：" + (price - machine.getCurrentAmount()) + "元");
        }
    }

    @Override
    public void dispense() {
        System.out.println("请先选择商品！");
    }
}