package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.ReductionPlan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ReductionPlanMapper extends BaseMapper<ReductionPlan> {
    @Select("SELECT max(reduction_money) FROM reduction_plan WHERE reduction_require>=#{reductionRequire}")
    float bestPlan(@Param("reductionRequire")float reductionRequire);
}
