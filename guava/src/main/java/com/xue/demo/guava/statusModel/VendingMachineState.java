package com.xue.demo.guava.statusModel;

/**
 * 状态接口（State）
 */
public interface VendingMachineState {
    /**
     * 状态方法 - 投币
     *
     * @param amount 投币金额
     */
    void insertCoin(int amount);

    /**
     * 状态方法 - 选择商品
     *
     * @param product 商品名称
     */
    void selectProduct(String product);

    /**
     * 状态方法 - 出货
     */
    void dispense();
}