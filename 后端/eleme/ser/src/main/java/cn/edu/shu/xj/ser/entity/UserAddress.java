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

    public UserAddress(){}

    public UserAddress(long addressId, long userId, String userAddress, int mainAddress, String userName, int userSex, String addressDetail, int addressType) {
        this.addressId = addressId;
        this.userId = userId;
        this.userAddress = userAddress;
        this.mainAddress = mainAddress;
        this.userName = userName;
        this.userSex = userSex;
        this.addressDetail = addressDetail;
        this.addressType = addressType;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public int getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(int mainAddress) {
        this.mainAddress = mainAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public int getAddressType() {
        return addressType;
    }

    public void setAddressType(int addressType) {
        this.addressType = addressType;
    }
}
