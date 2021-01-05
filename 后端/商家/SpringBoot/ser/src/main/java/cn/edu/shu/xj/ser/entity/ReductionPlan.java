package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("reduction_plan")
public class ReductionPlan {
    @TableId(value = "plan_id",type = IdType.AUTO)
    private long planId;
    @TableField(value = "store_id")
    private long storeId;
    @TableField(value = "reduction_require")
    private float reductionRequire;
    @TableField(value = "reduction_money")
    private float reductionMoney;
}
