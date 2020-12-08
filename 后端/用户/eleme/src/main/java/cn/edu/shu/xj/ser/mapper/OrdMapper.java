package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.ord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface OrdMapper {
    /**
     * @param ordid
     * @return
     */
    @Select("SELECT * FROM ord WHERE ord_id =#{ordid} ")
    ord findOneOrder(@Param("ordid") String ordid);
}
