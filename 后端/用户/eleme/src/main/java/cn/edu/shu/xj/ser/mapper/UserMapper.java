package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.user;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


@Component
public interface UserMapper {

    @Select("SELECT * FROM user WHERE user_id =#{userid} ")
    user findOneUser(@Param("userid") String userid);
}
