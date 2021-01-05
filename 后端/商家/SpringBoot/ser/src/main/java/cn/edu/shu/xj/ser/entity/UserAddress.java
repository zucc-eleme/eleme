package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_address")
public class UserAddress {
    @TableId(value = "address_id")
    private long addressId;
    @TableField(value = "user_id")
    private long userId;
    @TableField(value = "user_address")
    private String userAddress;
    @TableField(value = "main_address")
    private int mainAddress;
    @TableField(value = "user_name")
    private String userName;
    @TableField(value = "user_sex")
    private int userSex;
    @TableField(value = "address_detail")
    private String addressDetail;
    @TableField(value = "address_type")
    private int addressType;
}
