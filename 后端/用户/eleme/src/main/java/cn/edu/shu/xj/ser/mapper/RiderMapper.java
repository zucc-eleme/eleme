package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.Rider;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
public interface RiderMapper extends BaseMapper<Rider> {
    /**
     * @param riderId
     * @return
     */
    @Select("SELECT * FROM rider " +
            "WHERE rider_id =#{riderId} ")
    Rider findOneRiderById(@Param("riderId")long riderId);

    /**
     * @param riderPhone
     * @return
     */
    @Select("SELECT * FROM rider " +
            "WHERE rider_phone =#{riderPhone} ")
    Rider findOneRiderByPhone(@Param("riderPhone")String riderPhone);

    @Select("SELECT MAX(rider_id) FROM rider")
    long getMaxRiderId();

    @Update("UPDATE rider set rider=#{riderPwd} where rider_phone = #{riderPhone}")
    boolean changeRiderPwd(@Param("riderPhone") String riderPhone,@Param("riderPwd") String riderPwd);
}
