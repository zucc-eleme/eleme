package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("goods")
public class Goods {
    @TableId(value = "goods_id",type = IdType.AUTO)
    private long goodsId;
    @TableField(value = "class_name")
    private String className;
    @TableField(value = "store_id")
    private long storeId;
    @TableField(value = "goods_name")
    private String goodsName;
    @TableField(value = "goods_price")
    private float goodsPrice;
    @TableField(value = "goods_picture")
    private String goodsPicture;
    @TableField(value = "goods_description")
    private String goodsDescription;
    @TableField(value = "month_sales")
    private int monthSales;
    @TableField(value = "high_rating")
    private float highRating;

    public Goods(){}
    public Goods(long goodsId, String className, long storeId, String goodsName, float goodsPrice, String goodsPicture, String goodsDescription, int monthSales, float highRating) {
        this.goodsId = goodsId;
        this.className = className;
        this.storeId = storeId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsPicture = goodsPicture;
        this.goodsDescription = goodsDescription;
        this.monthSales = monthSales;
        this.highRating = highRating;
    }

    public Goods(String className, long storeId, String goodsName, float goodsPrice, String goodsPicture, String goodsDescription) {
        this.className = className;
        this.storeId = storeId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsPicture = goodsPicture;
        this.goodsDescription = goodsDescription;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public int getMonthSales() {
        return monthSales;
    }

    public void setMonthSales(int monthSales) {
        this.monthSales = monthSales;
    }

    public float getHighRating() {
        return highRating;
    }

    public void setHighRating(float highRating) {
        this.highRating = highRating;
    }
}
