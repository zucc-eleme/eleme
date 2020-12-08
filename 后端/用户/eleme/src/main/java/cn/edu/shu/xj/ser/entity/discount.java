package cn.edu.shu.xj.ser.entity;

public class discount {//用户优惠券
    private String discount_id; //优惠券id
    private String user_id; //用户id
    private String discount_name; //优惠券名称
    private float discount_money; //优惠价格
    private float start_money; //使用优惠券的最低价格

    public String getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(String discount_id) {
        this.discount_id = discount_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDiscount_name() {
        return discount_name;
    }

    public void setDiscount_name(String discount_name) {
        this.discount_name = discount_name;
    }

    public float getDiscount_money() {
        return discount_money;
    }

    public void setDiscount_money(float discount_money) {
        this.discount_money = discount_money;
    }

    public float getStart_money() {
        return start_money;
    }

    public void setStart_money(float start_money) {
        this.start_money = start_money;
    }
}
