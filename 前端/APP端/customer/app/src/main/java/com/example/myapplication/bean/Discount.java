package com.example.myapplication.bean;

public class Discount {
    String discountId;
    Long userId;
    String discountName;
    float discountMoney;
    float startMoney;
    Long storeId;

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public float getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(float discountMoney) {
        this.discountMoney = discountMoney;
    }

    public float getStartMoney() {
        return startMoney;
    }

    public void setStartMoney(float startMoney) {
        this.startMoney = startMoney;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
