package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("rider")
public class Rider {
    @TableId(value = "rider_id")
    private long riderId;
    @TableField(value = "rider_name")
    private String riderName;
    @TableField(value = "rider_passwd")
    private String riderPasswd;
    @TableField(value = "rider_phone")
    private String riderPhone;
    @TableField(value = "rider_position")
    private String riderPosition;

    public Rider(){
    }

    public Rider(long riderId, String riderName, String riderPasswd, String riderPhone, String riderPosition) {
        this.riderId = riderId;
        this.riderName = riderName;
        this.riderPasswd = riderPasswd;
        this.riderPhone = riderPhone;
        this.riderPosition = riderPosition;
    }

    public long getRiderId() {
        return riderId;
    }

    public void setRiderId(long riderId) {
        this.riderId = riderId;
    }

    public String getRiderName() {
        return riderName;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    public String getRiderPasswd() {
        return riderPasswd;
    }

    public void setRiderPasswd(String riderPasswd) {
        this.riderPasswd = riderPasswd;
    }

    public String getRiderPhone() {
        return riderPhone;
    }

    public void setRiderPhone(String riderPhone) {
        this.riderPhone = riderPhone;
    }

    public String getRiderPosition() {
        return riderPosition;
    }

    public void setRiderPosition(String riderPosition) {
        this.riderPosition = riderPosition;
    }
}
