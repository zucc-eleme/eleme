package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;



@Component
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


}
