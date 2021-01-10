package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ord_goods")
public class OrdGoods {
    @TableField(value = "ord_id")
    private long ordId;
    @TableField(value = "goods_name")
    private String goodsName;
    @TableField(value = "goods_num")
    private int goodsNum;
    @TableField(value = "goods_price")
    private float goodsPrice;

    public OrdGoods(long ordId, String goodsName, int goodsNum, float goodsPrice) {
        this.ordId = ordId;
        this.goodsName = goodsName;
        this.goodsNum = goodsNum;
        this.goodsPrice = goodsPrice;
    }

    public long getOrdId() {
        return ordId;
    }

    public void setOrdId(long ordId) {
        this.ordId = ordId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}
