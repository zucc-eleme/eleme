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
}
