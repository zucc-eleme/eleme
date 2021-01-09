package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.UserAddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


@Component
public interface UserAddressMapper extends BaseMapper<UserAddress> {
    /**
     * @param userId
     * @return
     */
    @Select("SELECT * FROM user_address WHERE user_id =#{userId} ")
    UserAddress findOneUserAddress(@Param("userId") long userId);

    /**
     * @param addressId
     * @return
     */
    @Select("SELECT * FROM user_address WHERE address_id =#{addressId} ")
    UserAddress findOneUserAddressById(@Param("addressId")long addressId);

    /**
     * @param userId
     * @return
     */
    @Select("SELECT * FROM user_address WHERE user_id =#{userId} and main_address = 1")
    UserAddress findOneUserMainAddress(@Param("userId")long userId);
}
