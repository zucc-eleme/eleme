package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("discount")
public class Discount {//用户优惠券
    @TableId(value = "discount_id")
    private String discountId; //优惠券id
    @TableField(value = "user_id")
    private Long userId; //用户id
    @TableField(value = "discount_name")
    private String discountName; //优惠券名称
    @TableField(value = "discount_money")
    private float discountMoney; //优惠价格
    @TableField(value = "start_money")
    private float startMoney; //使用优惠券的最低价格
    @TableField(value = "store_id")
    private Long storeId;

    public Discount(){
    }
    public Discount(String discountId, Long userId, String discountName, float discountMoney, float startMoney, Long storeId) {
        this.discountId = discountId;
        this.userId = userId;
        this.discountName = discountName;
        this.discountMoney = discountMoney;
        this.startMoney = startMoney;
        this.storeId = storeId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
