package com.xue.demo.guava.statusModel;

public class DispensingState implements VendingMachineState {
    private final VendingMachine machine;

    public DispensingState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println("正在出货中，请稍后再投币！");
    }

    @Override
    public void selectProduct(String product) {
        System.out.println("正在出货中，请稍后再选择商品！");
    }

    @Override
    public void dispense() {
        String product = machine.getSelectedProduct();
        int price = machine.getProductPrice(product);
        int change = machine.getCurrentAmount() - price;

        System.out.println("--------------------------------");
        System.out.println("出货：" + product);
        if (change > 0) {
            System.out.println("找零：" + change + "元");
        }
        System.out.println("--------------------------------");

        // 重置状态
        machine.setCurrentAmount(0);
        machine.setSelectedProduct(null);
        machine.setCurrentState(machine.getNoMoneyState());
    }
}