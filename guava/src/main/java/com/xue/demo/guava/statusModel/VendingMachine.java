package com.xue.demo.guava.statusModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendingMachine {
    private VendingMachineState noMoneyState;
    private VendingMachineState hasMoneyState;
    private VendingMachineState dispensingState;
    private VendingMachineState currentState;

    private int currentAmount;  // 当前金额
    private String selectedProduct;  // 选中的商品

    public VendingMachine() {
        noMoneyState = new NoMoneyState(this);
        hasMoneyState = new HasMoneyState(this);
        dispensingState = new DispensingState(this);
        currentState = noMoneyState;
    }

    // 业务方法 - 委托给当前状态处理
    public void insertCoin(int amount) {
        currentState.insertCoin(amount);
    }

    public void selectProduct(String product) {
        currentState.selectProduct(product);
    }

    public void dispense() {
        currentState.dispense();
    }
    // 模拟商品价格查询
    public int getProductPrice(String product) {
        int price = -1;
        switch (product) {
            case "可乐":
                price = 3;
                break;
            case "雪碧":
                price = 3;
                break;
            case "矿泉水":
                price = 2;
                break;
            default:
                price = -1;
        }
        return price;
    }
}