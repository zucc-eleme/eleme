package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("discount")
public class Discount {
    @TableId(value = "discount_id")
    private long discountId;
    @TableField(value = "user_id")
    private long userId;
    @TableField(value = "store_id")
    private long storeId;
    @TableField(value = "discount_name")
    private String discountName;
    @TableField(value = "discount_money")
    private float discountMoney;
    @TableField(value = "start_money")
    private float startMoney;
    public Discount(){}

    public Discount(long discountId, long userId, long storeId, String discountName, float discountMoney, float startMoney) {
        this.discountId = discountId;
        this.userId = userId;
        this.storeId = storeId;
        this.discountName = discountName;
        this.discountMoney = discountMoney;
        this.startMoney = startMoney;
    }

    public long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(long discountId) {
        this.discountId = discountId;
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
}
