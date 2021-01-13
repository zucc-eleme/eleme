package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.RiderEvaluation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RiderEvaluationMapper extends BaseMapper<RiderEvaluation> {
    /**
     * @param riderId
     * @return
     */
    @Select("SELECT SUM(rider_stars) FROM rider_evaluation " +
            "WHERE rider_id =#{riderId} ")
    float getRiderAllStars(@Param("riderId")long riderId);

    /**
     * @param riderId
     * @return
     */
    @Select("SELECT COUNT(*) FROM rider_evaluation " +
            "WHERE rider_id =#{riderId} ")
    int getRiderAllCounts(@Param("riderId")long riderId);

    /**
     * @param riderId
     * @return
     */
    @Select("SELECT user_id FROM rider_evaluation " +
            "WHERE rider_id =#{riderId} ")
    List<Long> getAllUserId(@Param("riderId")long riderId);


}
