package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("goods_evaluation")
public class GoodsEvaluation {
    @TableField(value = "store_id")
    private long storeId;
    @TableField(value = "user_id")
    private long userId;
    @TableField(value = "user_name")
    private String userName;
    @TableField(value = "evaluation_content")
    private String evaluationContent;
    @TableField(value = "evaluation_star")
    private float evaluationStar;
    @TableField(value = "evaluation_img")
    private String evaluationImg;
    @TableField(value = "evaluation_time")
    private Date evaluationTime;

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
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

    public String getEvaluationContent() {
        return evaluationContent;
    }

    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent;
    }

    public float getEvaluationStar() {
        return evaluationStar;
    }

    public void setEvaluationStar(float evaluationStar) {
        this.evaluationStar = evaluationStar;
    }

    public String getEvaluationImg() {
        return evaluationImg;
    }

    public void setEvaluationImg(String evaluationImg) {
        this.evaluationImg = evaluationImg;
    }

    public Date getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(Date evaluationTime) {
        this.evaluationTime = evaluationTime;
    }
}
