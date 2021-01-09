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
}
