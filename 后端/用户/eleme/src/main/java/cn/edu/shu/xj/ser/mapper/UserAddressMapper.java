package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.UserAddress;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


@Component
public interface UserAddressMapper {
    /**
     * @param userid
     * @return
     */
    @Select("SELECT * FROM user_address WHERE user_id =#{userid} ")
    UserAddress findOneUserAddress(@Param("userid") String userid);
}
