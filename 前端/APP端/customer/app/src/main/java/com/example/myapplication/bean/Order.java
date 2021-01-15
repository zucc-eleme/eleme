package com.example.myapplication.bean;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    long ordId;
    long userId;
    long storeId;
    long riderId;
    float totalMoney;
    float totalDiscount;
    Date ordTime;
    float riderGet;
    int isReturn;
    /*
     **0表示创建但未下单
     * 1表示已下单但未送达
     * 2表示已退单
     * 3表示订单已送达
     */

    public long getOrdId() {
        return ordId;
    }

    public void setOrdId(long ordId) {
        this.ordId = ordId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public long getRiderId() {
        return riderId;
    }

    public void setRiderId(long riderId) {
        this.riderId = riderId;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public float getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(float totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Date getOrdTime() {
        return ordTime;
    }

    public void setOrdTime(Date ordTime) {
        this.ordTime = ordTime;
    }

    public float getRiderGet() {
        return riderGet;
    }

    public void setRiderGet(float riderGet) {
        this.riderGet = riderGet;
    }

    public int getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(int isReturn) {
        this.isReturn = isReturn;
    }
}
