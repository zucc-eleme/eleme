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

    public RiderEvaluation(){}

    public RiderEvaluation(long evaluationId, long riderId, long userId, String userName, String riderEvaluate, float riderStars, Date evaluateTime) {
        this.evaluationId = evaluationId;
        this.riderId = riderId;
        this.userId = userId;
        this.userName = userName;
        this.riderEvaluate = riderEvaluate;
        this.riderStars = riderStars;
        this.evaluateTime = evaluateTime;
    }

    public long getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(long evaluationId) {
        this.evaluationId = evaluationId;
    }

    public long getRiderId() {
        return riderId;
    }

    public void setRiderId(long riderId) {
        this.riderId = riderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRiderEvaluate() {
        return riderEvaluate;
    }

    public void setRiderEvaluate(String riderEvaluate) {
        this.riderEvaluate = riderEvaluate;
    }

    public float getRiderStars() {
        return riderStars;
    }

    public void setRiderStars(float riderStars) {
        this.riderStars = riderStars;
    }

    public Date getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(Date evaluateTime) {
        this.evaluateTime = evaluateTime;
    }
}
