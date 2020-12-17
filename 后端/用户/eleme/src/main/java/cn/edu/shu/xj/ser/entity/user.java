package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.intellij.lang.annotations.Pattern;

@Data
@TableName("user")
public class User {
    @TableId(value = "user_id")
    private long userId;
    private String userName;
    private String userPwd;
    private String userMainAddress;
//    @Pattern(regexp = RegexUtil.PHONE, message = "请填写正确的手格式")
    private String userPhone;
    //性别，0是先生，1是女士
    private int userSex;

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

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserMainAddress() {
        return userMainAddress;
    }

    public void setUserMainAddress(String userMainAddress) {
        this.userMainAddress = userMainAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }
}
