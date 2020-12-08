package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.discount;
import cn.edu.shu.xj.ser.entity.user_address;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface DisountMapper {
    /**
     * @param discountid
     * @return
     */
    @Select("SELECT * FROM discount WHERE discount_id =#{discountid} ")
    discount findOneUserAddress(@Param("discountid") String discountid);
}
