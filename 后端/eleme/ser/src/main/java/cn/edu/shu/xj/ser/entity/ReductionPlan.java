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

    public ReductionPlan(){}

    public ReductionPlan(long planId, long storeId, float reductionRequire, float reductionMoney) {
        this.planId = planId;
        this.storeId = storeId;
        this.reductionRequire = reductionRequire;
        this.reductionMoney = reductionMoney;
    }

    public long getPlanId() {
        return planId;
    }

    public void setPlanId(long planId) {
        this.planId = planId;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public float getReductionRequire() {
        return reductionRequire;
    }

    public void setReductionRequire(float reductionRequire) {
        this.reductionRequire = reductionRequire;
    }

    public float getReductionMoney() {
        return reductionMoney;
    }

    public void setReductionMoney(float reductionMoney) {
        this.reductionMoney = reductionMoney;
    }
}
