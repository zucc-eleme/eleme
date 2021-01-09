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
}
