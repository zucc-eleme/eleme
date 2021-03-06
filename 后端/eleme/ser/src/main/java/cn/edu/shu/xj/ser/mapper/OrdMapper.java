package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.Ord;
import cn.edu.shu.xj.ser.entity.Store;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrdMapper extends BaseMapper<Ord> {

    @Select("SELECT * FROM ord WHERE TO_DAYS(NOW())-TO_DAYS(ord_time)<=#{day} AND store_id=#{storeId}")
    List<Ord> ordsBeforeTime(@Param("day")int day, @Param("storeId") long storeId);

    @Select("SELECT SUM(total_discount) FROM ord WHERE TO_DAYS(NOW())-TO_DAYS(ord_time)=#{day} AND store_id=#{storeId}")
    float profitInOneDay(@Param("day")int day, @Param("storeId") long storeId);

    @Select("SELECT COUNT(*) FROM ord WHERE TO_DAYS(NOW())-TO_DAYS(ord_time)=#{day} AND store_id=#{storeId}")
    int saveVolumeBeforeTime(@Param("day")int day, @Param("storeId") long storeId);

    @Select("SELECT SUM(total_money)/COUNT(*) FROM ord WHERE store_id=#{storeId} AND is_return=#{isReturn}")
    float averageConsumption(@Param("storeId")long storeId,@Param("isReturn") int isReturn);

    @Select("SELECT * FROM ord WHERE store_id=#{storeId} AND user_id=#{userId}  AND is_return=0")
    Ord findOrd(@Param("storeId")long storeId,@Param("userId")long userId);

    /**
     * @param ordid
     * @return
     */
    @Select("SELECT * FROM ord WHERE ord_id =#{ordid} ")
    Ord findOneOrder(@Param("ordid") String ordid);
}
