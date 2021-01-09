package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_address")
public class UserAddress {
    @TableField(value = "user_id")
    private Long userId;     //记录用户id
    @TableId(value = "address_id")
    private Long addressId; //地址id
    @TableField(value = "user_address")
    private String userAddress; //记录地址
    @TableField(value = "main_address")
    private int mainAddress; //判断是否为主地址
    @TableField(value = "user_name")
    private String userName;//用户姓名
    @TableField(value = "user_sex")
    private int userSex;   //用户性别，0是先生，1是女士，可以不设置
    @TableField(value = "address_detail")
    private String addressDetail; //地址详细信息，可以不设置
    @TableField(value = "address_type")
    private int addressType;   //地址类型，0是家，1是学校，2是公司，可以不设置


    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
