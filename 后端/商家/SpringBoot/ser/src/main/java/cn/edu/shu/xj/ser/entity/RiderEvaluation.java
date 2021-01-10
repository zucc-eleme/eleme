package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("rider_evaluation")
public class RiderEvaluation {
    @TableId(value = "evaluation_id",type = IdType.AUTO)
    private long evaluationId;
    @TableField(value = "rider_id")
    private long riderId;
    @TableField(value = "user_id")
    private long userId;
    @TableField(value = "user_name")
    private String userName;
    @TableField(value = "rider_evaluate")
    private String riderEvaluate;
    @TableField(value = "rider_stars")
    private float riderStars;
    @TableField(value = "evaluate_time")
    private Date evaluateTime;
}
