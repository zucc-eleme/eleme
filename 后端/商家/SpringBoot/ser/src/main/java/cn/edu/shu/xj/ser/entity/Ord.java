package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("ord")
public class Ord {
    @TableId(value = "ord_id",type = IdType.AUTO)
    private long ordId;
    @TableField(value = "user_id")
    private long userId;
    @TableField(value = "store_id")
    private long storeId;
    @TableField(value = "rider_id")
    private long riderId;
    @TableField(value = "total_money")
    private float totalMoney;
    @TableField(value = "total_discount")
    private float totalDiscount;
    @TableField(value = "ord_time")
    private Date ordTime;
    @TableField(value = "rider_get")
    private float riderGet;
    @TableField(value = "is_return")
    private int isReturn;

    public Ord(long ordId, long userId, long storeId, long riderId, float totalMoney, float totalDiscount, Date ordTime, float riderGet, int isReturn) {
        this.ordId = ordId;
        this.userId = userId;
        this.storeId = storeId;
        this.riderId = riderId;
        this.totalMoney = totalMoney;
        this.totalDiscount = totalDiscount;
        this.ordTime = ordTime;
        this.riderGet = riderGet;
        this.isReturn = isReturn;
    }

    public Ord(long userId, long storeId, long riderId, float totalMoney, float totalDiscount, Date ordTime, float riderGet, int isReturn) {
        this.userId = userId;
        this.storeId = storeId;
        this.riderId = riderId;
        this.totalMoney = totalMoney;
        this.totalDiscount = totalDiscount;
        this.ordTime = ordTime;
        this.riderGet = riderGet;
        this.isReturn = isReturn;
    }

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
