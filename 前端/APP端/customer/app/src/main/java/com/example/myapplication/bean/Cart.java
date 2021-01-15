package com.example.myapplication.bean;

import android.util.SparseArray;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Cart implements Serializable {
    private SparseArray<GoodsItem> purchased=new SparseArray<GoodsItem>();
    private long service;
    private long customer;

    public Cart(long customer,long service,SparseArray<GoodsItem> purchased){
        this.purchased=purchased;
        this.service=service;
        this.customer=customer;
    }

    public Cart(long service,long customer){
        this.service=service;
        this.customer=customer;
    }

    public SparseArray<GoodsItem> getPurchased() {
        return purchased;
    }

    public void setPurchased(SparseArray<GoodsItem> purchased) {
        this.purchased = purchased;
    }

    public long getService() {
        return service;
    }

    public void setService(long service) {
        this.service = service;
    }

    public long getCustomer() {
        return customer;
    }

    public void setCustomer(long customer) {
        this.customer = customer;
    }

}
