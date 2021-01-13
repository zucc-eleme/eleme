package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper extends BaseMapper<User> {
    /**
     * @param userId
     * @return
     */
    @Select("SELECT * FROM user WHERE user_id = #{userId}")
    User findOneUser(@Param("userId") long userId);

    /**
     * @param userPhone
     * @return
     */
    @Select("SELECT * FROM user WHERE user_phone = #{userPhone}")
    User findOneUserByPhone(@Param("userPhone") String userPhone);

    @Select("SELECT COUNT(user_id) FROM user")
    long getMaxUserId();

    @Update("UPDATE user set user_pwd=#{userPwd} where user_phone = #{userPhone}")
    boolean changeUserPwd(@Param("userPhone") String userPhone,@Param("userPwd") String userPwd);

}
