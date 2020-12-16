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
}
