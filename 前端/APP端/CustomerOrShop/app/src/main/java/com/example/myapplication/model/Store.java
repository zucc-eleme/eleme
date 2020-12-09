package com.example.myapplication.model;

import com.google.gson.Gson;

import java.util.Date;

public class Store {

    /**
     * store_id : 商家id
     * store_name : 商家名
     * store_passwd : 密码
     * store_address : 地址
     * store_phone : 电话
     * delivery_begin : 开门时间
     * delivery_end : 打烊时间
     */

    private String store_id;
    private String store_name;
    private String store_passwd;
    private String store_address;
    private String store_phone;
    private Date delivery_begin;
    private Date delivery_end;

    public static Store objectFromData(String str) {
        return new Gson().fromJson(str, Store.class);
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_passwd() {
        return store_passwd;
    }

    public void setStore_passwd(String store_passwd) {
        this.store_passwd = store_passwd;
    }

    public String getStore_address() {
        return store_address;
    }

    public void setStore_address(String store_address) {
        this.store_address = store_address;
    }

    public String getStore_phone() {
        return store_phone;
    }

    public void setStore_phone(String store_phone) {
        this.store_phone = store_phone;
    }

    public Date getDelivery_begin() {
        return delivery_begin;
    }

    public void setDelivery_begin(Date delivery_begin) {
        this.delivery_begin = delivery_begin;
    }

    public Date getDelivery_end() {
        return delivery_end;
    }

    public void setDelivery_end(Date delivery_end) {
        this.delivery_end = delivery_end;
    }

}
