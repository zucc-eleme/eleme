package cn.edu.shu.xj.ser.entity;

public class Discount {//用户优惠券
    private String discountId; //优惠券id
    private Long userId; //用户id
    private String discountName; //优惠券名称
    private float discountMoney; //优惠价格
    private float startMoney; //使用优惠券的最低价格

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
