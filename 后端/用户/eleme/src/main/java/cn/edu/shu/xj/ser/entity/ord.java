package cn.edu.shu.xj.ser.entity;

import java.util.Date;

public class Ord {
    private String ordId; //订单id
    private Long userId; //用户id
    private int storeId; //商家id
    private int riderId; //骑手id
    private float totalMoney; //总价
    private float totalDiscount; //满减
    private Date ordTime; //预计下单时间
    private float riderGet; //配送费

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getRiderId() {
        return riderId;
    }

    public void setRiderId(int riderId) {
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
}
