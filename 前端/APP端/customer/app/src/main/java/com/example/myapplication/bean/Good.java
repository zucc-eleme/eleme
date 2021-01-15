package com.example.myapplication.bean;

import java.util.Comparator;

public class Good implements Comparator<Good> {
    long goodsId;
    String className;
    long storeId;
    String goodsName;
    double goodsPrice;
    String goodsPicture;
    String goodsDescription;
    int monthSales;
    float highRating;

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public int getMonthSales() {
        return monthSales;
    }

    public void setMonthSales(int monthSales) {
        this.monthSales = monthSales;
    }

    public float getHighRating() {
        return highRating;
    }

    public void setHighRating(float highRating) {
        this.highRating = highRating;
    }


    @Override
    public int compare(Good o1, Good o2) {
        return o1.getClassName().compareTo(o2.getClassName());
    }
}
