package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableId(value = "user_id")
    private long userId;
    @TableField(value = "user_name")
    private String userName;
    @TableField(value = "user_phone")
    private String userPhone;
    @TableField(value = "user_pwd")
    private String userPwd;
    @TableField(value = "user_address_id")
    private long userAddressId;
    @TableField(value = "user_main_address")
    private String userMainAddress;
    @TableField(value = "user_sex")
    private int userSex;
}