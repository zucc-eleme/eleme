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
    //订单id
    @TableId(value = "ord_id",type = IdType.AUTO)
    private long ordId;
    //用户id
    @TableField(value = "user_id")
    private long userId;
    //商家id
    @TableField(value = "store_id")
    private long storeId;
    //骑手id
    @TableField(value = "rider_id")
    private long riderId;
    //商品总值
    @TableField(value = "total_money")
    private float totalMoney;
    //满减+折扣
    @TableField(value = "total_discount")
    private float totalDiscount;
    //下单时间
    @TableField(value = "ord_time")
    private Date ordTime;
    //骑手运送费用
    @TableField(value = "rider_get")
    private float riderGet;
    /*
    **0表示创建但未下单
    * 1表示已下单但未送达
    * 2表示已退单
    * 3表示订单已送达
     */
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

    public Ord(long userId, long storeId, float totalMoney, int isReturn) {
        this.userId = userId;
        this.storeId = storeId;
        this.totalMoney = totalMoney;
        this.isReturn=isReturn;
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
