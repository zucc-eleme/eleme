package com.example.myapplication.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GoodsItem implements Serializable {
    public int id;
    public int typeId;
    public int rating;
    public String name;
    public String typeName;
    public double price;
    public int scaleNum;
    public int count;

    public GoodsItem(int id, double price, int scaleNum, String name, int typeId, String typeName, int rating) {
        this.id = id;
        this.price = price;
        this.scaleNum=scaleNum;
        this.name = name;
        this.typeId = typeId;
        this.typeName = typeName;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public int getTypeId() {
        return typeId;
    }

    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public String getTypeName() {
        return typeName;
    }

    public double getPrice() {
        return price;
    }

    public int getScaleNum() {
        return scaleNum;
    }

    public int getCount() {
        return count;
    }
}
