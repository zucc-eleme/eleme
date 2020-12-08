package cn.edu.shu.xj.ser.entity;

import java.util.Date;

public class ord {
    private String ord_id; //订单id
    private String user_id; //用户id
    private int store_id; //商家id
    private int rider_id; //骑手id
    private float total_money; //总价
    private float total_discount; //满减
    private Date ord_time; //预计下单时间
    private float rider_get; //配送费

    public String getOrd_id() {
        return ord_id;
    }

    public void setOrd_id(String ord_id) {
        this.ord_id = ord_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getRider_id() {
        return rider_id;
    }

    public void setRider_id(int rider_id) {
        this.rider_id = rider_id;
    }

    public float getTotal_money() {
        return total_money;
    }

    public void setTotal_money(float total_money) {
        this.total_money = total_money;
    }

    public float getTotal_discount() {
        return total_discount;
    }

    public void setTotal_discount(float total_discount) {
        this.total_discount = total_discount;
    }

    public Date getOrd_time() {
        return ord_time;
    }

    public void setOrd_time(Date ord_time) {
        this.ord_time = ord_time;
    }

    public float getRider_get() {
        return rider_get;
    }

    public void setRider_get(float rider_get) {
        this.rider_get = rider_get;
    }
}
