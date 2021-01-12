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

    public User(){}

    public User(long userId, String userName, String userPhone, String userPwd, long userAddressId, String userMainAddress, int userSex) {
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userPwd = userPwd;
        this.userAddressId = userAddressId;
        this.userMainAddress = userMainAddress;
        this.userSex = userSex;
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

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public long getUserAddressId() {
        return userAddressId;
    }

    public void setUserAddressId(long userAddressId) {
        this.userAddressId = userAddressId;
    }

    public String getUserMainAddress() {
        return userMainAddress;
    }

    public void setUserMainAddress(String userMainAddress) {
        this.userMainAddress = userMainAddress;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }
}